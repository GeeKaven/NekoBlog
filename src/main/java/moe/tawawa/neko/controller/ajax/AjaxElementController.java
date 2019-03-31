package moe.tawawa.neko.controller.ajax;

import moe.tawawa.neko.model.domain.User;
import moe.tawawa.neko.model.enums.ErrorCode;
import moe.tawawa.neko.model.request.CategoryCreateRequest;
import moe.tawawa.neko.model.request.TagCreateRequest;
import moe.tawawa.neko.model.response.JsonResponse;
import moe.tawawa.neko.model.response.data.CreateData;
import moe.tawawa.neko.service.ElementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: laiang
 * @date: 2019/3/31 23:21
 */
@RestController
@RequestMapping(value = "/api/admin/element")
public class AjaxElementController {

    private final ElementService elementService;

    @Autowired
    public AjaxElementController(ElementService elementService) {
        this.elementService = elementService;
    }

    @PostMapping(value = "/category/add")
    public JsonResponse addCategory(@RequestBody CategoryCreateRequest request) {
        CreateData createData = elementService.createCategory(request, new User());
        return new JsonResponse(ErrorCode.SUCCESS.getCode(), ErrorCode.SUCCESS.getErrorMsg(), createData);
    }

    @PostMapping(value = "/tag/add")
    public JsonResponse addTag(@RequestBody TagCreateRequest request) {
        CreateData createData = elementService.createTag(request, new User());
        return new JsonResponse(ErrorCode.SUCCESS.getCode(), ErrorCode.SUCCESS.getErrorMsg(), createData);
    }
}
