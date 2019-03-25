package moe.tawawa.neko.controller.api;

import moe.tawawa.neko.model.enums.ErrorCode;
import moe.tawawa.neko.model.request.ListRequest;
import moe.tawawa.neko.model.response.JsonResponse;
import moe.tawawa.neko.model.response.data.ListData;
import moe.tawawa.neko.model.vo.PostVO;
import moe.tawawa.neko.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: GeeKaven
 * @date: 2019/3/20 23:07
 */
@RestController
@RequestMapping(value = "/api/post/")
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping(value = "/page/{page}")
    public JsonResponse queryPostByPage(@RequestBody ListRequest request) {
        ListData<PostVO> result = postService.getPostListByPage(request);
        return new JsonResponse(ErrorCode.SUCCESS.getCode(), ErrorCode.SUCCESS.getErrorMsg(), result);
    }

    @GetMapping(value = "{post_id}")
    public JsonResponse queryPostDetail(@PathVariable(value = "post_id") Long postId) {
        PostVO postVO = postService.getPostInfo(postId);
        return new JsonResponse(ErrorCode.SUCCESS.getCode(), ErrorCode.SUCCESS.getErrorMsg(), postVO);
    }
}