package moe.tawawa.neko.controller.admin;

import moe.tawawa.neko.model.response.data.ListData;
import moe.tawawa.neko.model.vo.CategoryVO;
import moe.tawawa.neko.model.vo.TagVO;
import moe.tawawa.neko.service.ElementService;
import moe.tawawa.neko.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: GeeKaven
 * @date: 2019/3/21 0:03
 */
@Controller
@RequestMapping(value = "/admin")
public class AdminHomeController {

    private final PostService postService;

    private final ElementService elementService;

    @Autowired
    public AdminHomeController(PostService postService, ElementService elementService) {
        this.postService = postService;
        this.elementService = elementService;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("title", "后台管理/仪表盘");
        return "admin/index";
    }

    @GetMapping(value = "/meta")
    public String categoryList(Model model) {

        ListData<CategoryVO> catList = elementService.queryAllCategory();
        ListData<TagVO> tagList = elementService.queryAllTag();

        model.addAttribute("categories", catList.getList());
        model.addAttribute("tags", tagList.getList());
        model.addAttribute("title", "后台管理/类目标签管理");
        return "admin/meta";
    }
}
