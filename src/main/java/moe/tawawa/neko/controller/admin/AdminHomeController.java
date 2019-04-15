package moe.tawawa.neko.controller.admin;

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

    @Autowired
    public AdminHomeController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("title", "后台管理/仪表盘");
        return "admin/index";
    }

    @GetMapping(value = "/category")
    public String categoryList(Model model) {
        model.addAttribute("title", "后台管理/类目管理");
        return "admin/category";
    }

    @GetMapping(value = "/tag")
    public String tagList(Model model) {
        model.addAttribute("title", "后台管理/标签管理");
        return "admin/tag";
    }
}
