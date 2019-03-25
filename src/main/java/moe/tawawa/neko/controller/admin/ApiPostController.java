package moe.tawawa.neko.controller.admin;

import moe.tawawa.neko.model.enums.ErrorCode;
import moe.tawawa.neko.model.request.PostCreateRequest;
import moe.tawawa.neko.model.request.PostUpdateRequest;
import moe.tawawa.neko.model.response.JsonResponse;
import moe.tawawa.neko.model.response.data.CreateData;
import moe.tawawa.neko.model.response.data.VoidData;
import moe.tawawa.neko.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: GeeKaven
 * @date: 2019/3/25 19:49
 */
@RestController
@RequestMapping(value = "/api/admin/post")
public class ApiPostController {

    private final PostService postService;

    @Autowired
    public ApiPostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping(value = "/create")
    public JsonResponse createPost(@RequestBody PostCreateRequest request) {
        CreateData createData = postService.createPost(request);
        return new JsonResponse(ErrorCode.SUCCESS.getCode(), ErrorCode.SUCCESS.getErrorMsg(), createData);
    }

    @PostMapping(value = "/update")
    public JsonResponse updatePost(@RequestBody PostUpdateRequest request) {
        postService.updatePost(request);
        return new JsonResponse(ErrorCode.SUCCESS.getCode(), ErrorCode.SUCCESS.getErrorMsg(), new VoidData());
    }
}
