package moe.tawawa.neko.controller.api;

import moe.tawawa.neko.model.enums.ErrorCode;
import moe.tawawa.neko.model.request.ElementPostRequest;
import moe.tawawa.neko.model.response.JsonResponse;
import moe.tawawa.neko.model.response.data.ListData;
import moe.tawawa.neko.model.vo.PostVO;
import moe.tawawa.neko.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: GeeKaven
 * @date: 2019/3/25 19:52
 */
@RestController
public class ElementController {

    private final PostService postService;

    @Autowired
    public ElementController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping(value = "/api/category/post/list")
    public JsonResponse getPostListByCategory(@RequestBody ElementPostRequest request) {
        ListData<PostVO> postList = postService.getPostListByCategory(request);
        return new JsonResponse(ErrorCode.SUCCESS.getCode(), ErrorCode.SUCCESS.getErrorMsg(), postList);
    }

    @PostMapping(value = "/api/tag/post/list")
    public JsonResponse getPostListByTag(@RequestBody ElementPostRequest request) {
        ListData<PostVO> postList = postService.getPostListByTag(request);
        return new JsonResponse(ErrorCode.SUCCESS.getCode(), ErrorCode.SUCCESS.getErrorMsg(), postList);
    }
}
