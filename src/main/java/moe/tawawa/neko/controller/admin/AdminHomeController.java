package moe.tawawa.neko.controller.admin;

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

    @GetMapping
    public String index(Model model) {
        model.addAttribute("title", "后台管理");
        return "admin/index";
    }
}
