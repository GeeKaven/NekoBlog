package moe.tawawa.neko.service;

import moe.tawawa.neko.exception.BadRequestException;
import moe.tawawa.neko.model.domain.Post;
import moe.tawawa.neko.model.domain.PostTag;
import moe.tawawa.neko.model.domain.Tag;
import moe.tawawa.neko.model.domain.User;
import moe.tawawa.neko.model.enums.ErrorCode;
import moe.tawawa.neko.model.request.ElementPostRequest;
import moe.tawawa.neko.model.request.ListRequest;
import moe.tawawa.neko.model.request.PostCreateRequest;
import moe.tawawa.neko.model.request.PostTagRequest;
import moe.tawawa.neko.model.request.PostUpdateRequest;
import moe.tawawa.neko.model.response.data.CreateData;
import moe.tawawa.neko.model.response.data.ListData;
import moe.tawawa.neko.model.response.data.VoidData;
import moe.tawawa.neko.model.vo.PostVO;
import moe.tawawa.neko.repository.PostRepository;
import moe.tawawa.neko.repository.PostTagRepository;
import moe.tawawa.neko.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @author: GeeKaven
 * @date: 2019/3/18 8:10
 */
@Service
public class PostService {

    private final StickService stickService;

    private final PostRepository postRepository;

    private final TagRepository tagRepository;

    private final PostTagRepository postTagRepository;

    @Autowired
    public PostService(PostRepository postRepository,
                       TagRepository tagRepository,
                       PostTagRepository postTagRepository,
                       StickService stickService) {
        this.postRepository = postRepository;
        this.stickService = stickService;
        this.tagRepository = tagRepository;
        this.postTagRepository = postTagRepository;
    }

    /**
     * 创建文章
     * @param request 文章数据
     * @return 文章Id
     */
    @Transactional
    public CreateData createPost(PostCreateRequest request) {
        // TODO: 无类目时查询默认类目

        Post post = new Post();
        post.setEnableComment(request.getEnableComment());
        post.setTitle(request.getTitle());
        post.setContent(request.getContent());
        post.setSummary(request.getSummary());
        post.setPermalink(request.getPermalink());
        post.setCategoryId(request.getCategoryId());
        post.setType(request.getType());
        postRepository.save(post);

        return new CreateData(post.getId());
    }

    @Transactional
    public void updatePost(PostUpdateRequest request) {
        if (request.getId() == null) {
            throw new BadRequestException(ErrorCode.NOT_EXIST);
        }
        Post post = getPostById(request.getId());
        post.setTitle(request.getTitle());
        post.setContent(request.getContent());
        post.setEnableComment(request.getEnableComment());
        post.setType(request.getType());
        postRepository.save(post);
    }

    /**
     * 发布文章
     * @param postId  文章Id
     */
    public Long publishPost(Long postId) {
        return updateStatus(postId, Post.STATUS_PUBLISH);
    }

    /**
     * 删除文章
     * @param postId 文章Id
     */
    public Long deletePost(Long postId) {
        return updateStatus(postId, Post.STATUS_DEL);
    }

    public Page<Post> findAllByPage(int page, int size) {
        Pageable pageable = PageRequest.of(page, size , new Sort(Sort.Direction.DESC, "id"));
        return postRepository.findAll(pageable);
    }

    /**
     * 通过状态，类型获取文章列表
     * @return 文章列表
     */
    public ListData<PostVO> getPostListByPage(ListRequest request) {

        Pageable pageable = PageRequest.of(request.getPage(), request.getSize() , new Sort(Sort.Direction.DESC, "id"));
        Page<Post> postPage = postRepository.findByStatusAndType(Post.STATUS_PUBLISH, Post.TYPE_POST, pageable);
        return buildPostList(postPage);
    }

    public ListData<PostVO> getPostListByCategory(ElementPostRequest request) {

        Pageable pageable = PageRequest.of(request.getPage(), request.getSize() , new Sort(Sort.Direction.DESC, "id"));
        Page<Post> postPage = postRepository.findByStatusAndTypeAndCategoryId(Post.STATUS_PUBLISH, Post.TYPE_POST, request.getId(), pageable);
        return buildPostList(postPage);
    }

    public ListData<PostVO> getPostListByTag(ElementPostRequest request) {
        return null;
    }

    public CreateData addPostTag(PostTagRequest request) {
        PostTag postTag = new PostTag();
        postTag.setPostId(request.getPostId());
        postTag.setTagId(request.getTagId());
        postTagRepository.save(postTag);
        return new CreateData(postTag.getId());
    }

    @Transactional
    public void removePostTag(PostTagRequest request) {
        PostTag postTag = postTagRepository.findPostTagByPostIdAndTagId(request.getPostId(), request.getTagId());
        if (postTag == null) {
            throw new BadRequestException(ErrorCode.POST_TAG_NOT_EXIST);
        }
        postTagRepository.delete(postTag);
    }

    public PostVO getPostInfo(Long postId) {
        Post post = getPostById(postId);
        return stickService.getPostStickHelper(post)
                .getObject();
    }

    private Long updateStatus(Long postId, Integer status) {
        Post post = getPostById(postId);
        post.setStatus(status);
        return postRepository.save(post).getId();
    }

    private Post getPostById(Long postId) {
        Optional<Post> opPost = postRepository.findById(postId);
        if (!opPost.isPresent()) {
            throw new BadRequestException(ErrorCode.NOT_EXIST);
        }
        return opPost.get();
    }

    private ListData<PostVO> buildPostList(Page<Post> postPage) {
        List<PostVO> postList = stickService.getPostStickHelper(postPage.getContent())
                .getObjects();
        ListData<PostVO> result = new ListData<>();
        result.setList(postList);
        result.setSize(postPage.getTotalElements());
        return result;
    }
}
