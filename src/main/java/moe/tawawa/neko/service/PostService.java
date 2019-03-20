package moe.tawawa.neko.service;

import moe.tawawa.neko.exception.BadRequestException;
import moe.tawawa.neko.model.domain.Post;
import moe.tawawa.neko.model.domain.User;
import moe.tawawa.neko.model.enums.ErrorCode;
import moe.tawawa.neko.model.request.CreatePostRequest;
import moe.tawawa.neko.model.response.data.ListData;
import moe.tawawa.neko.model.vo.PostVO;
import moe.tawawa.neko.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
     * @param user 用户
     * @return 文章Id
     */
    public Long createPost(CreatePostRequest request, User user) {
        // TODO: 校验用户

        // TODO: 无类目时查询默认类目

        Post post = new Post();
        post.setEnableComment(request.getEnableComment());
        post.setTitle(request.getTitle());
        post.setContent(request.getContent());
        post.setCategoryId(request.getCategoryId());
        post.setType(request.getType());
        postRepository.save(post);

        return post.getId();
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
    public ListData<PostVO> getPostByStatusAndType(Integer status, Integer type, Pageable pageable) {

        Page<Post> postPage = postRepository.findByStatusAndType(status, type, pageable);
        List<PostVO> postList = chainService.getPostChainHelper(postPage.getContent()).getObjects();
        ListData<PostVO> result = new ListData<>();
        result.setList(postList);
        result.setSize(postPage.getTotalElements());
        return result;
    }

    private Long updateStatus(Long postId, Integer status) {
        Optional<Post> opPost = postRepository.findById(postId);
        if (!opPost.isPresent()) {
            throw new BadRequestException(ErrorCode.NOT_EXIST);
        }
        Post post = opPost.get();
        post.setStatus(status);
        return postRepository.save(post).getId();
    }
}
