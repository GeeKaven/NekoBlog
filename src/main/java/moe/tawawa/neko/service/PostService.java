package moe.tawawa.neko.service;

import moe.tawawa.neko.exception.BadRequestException;
import moe.tawawa.neko.model.domain.Post;
import moe.tawawa.neko.model.enums.ErrorCode;
import moe.tawawa.neko.model.request.CreatePostRequest;
import moe.tawawa.neko.model.request.UpdatePostRequest;
import moe.tawawa.neko.model.response.data.CreateData;
import moe.tawawa.neko.model.response.data.ListData;
import moe.tawawa.neko.model.vo.PostVO;
import moe.tawawa.neko.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    private final ChainService chainService;

    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository, ChainService chainService) {
        this.postRepository = postRepository;
        this.chainService = chainService;
    }

    /**
     * 创建文章
     * @param request 文章数据
     * @return 文章Id
     */
    @Transactional
    public CreateData createPost(CreatePostRequest request) {
        // TODO: 校验用户

        // TODO: 无类目时查询默认类目

        Post post = new Post();
        post.setEnableComment(request.getEnableComment());
        post.setTitle(request.getTitle());
        post.setContent(request.getContent());
        post.setCategoryId(request.getCategoryId());
        post.setType(request.getType());
        postRepository.save(post);

        return new CreateData(post.getId());
    }

    @Transactional
    public void updatePost(UpdatePostRequest request) {
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

    /**
     * 通过状态，类型获取文章列表
     * @param status 文章状态
     * @param type 文章类型
     * @param pageable 分页信息
     * @return 文章列表
     */
    public ListData<PostVO> getPostVOByStatusAndType(Integer status, Integer type, Pageable pageable) {

        Page<Post> postPage = postRepository.findByStatusAndType(status, type, pageable);
        List<PostVO> postList = chainService.getPostChainHelper(postPage.getContent())
                .getObjects();
        ListData<PostVO> result = new ListData<>();
        result.setList(postList);
        result.setSize(postPage.getTotalElements());
        return result;
    }

    public PostVO getPostVOById(Long postId) {
        Post post = getPostById(postId);
        return chainService.getPostChainHelper(post)
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
}
