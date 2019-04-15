package moe.tawawa.neko.controller.admin;

import moe.tawawa.neko.model.vo.PostVO;
import moe.tawawa.neko.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: laiang
 * @date: 2019/4/15 23:07
 */
@Controller
@RequestMapping(value = "/admin/post")
public class AdminPostController {
    private final PostService postService;

    @Autowired
    public AdminPostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping(value = "/create")
    public String createPost(Model model) {
        model.addAttribute("title", "文章管理/创建文章");
        return "admin/post/edit";
    }

    @GetMapping(value = "/{id}")
    public String updatePost(@PathVariable("id") Long id, Model model) {
        PostVO postVO = postService.getPostInfo(id);
        model.addAttribute("title", "文章管理/编辑文章");
        model.addAttribute("post", postVO);
        return "admin/post/edit";
    }
}
