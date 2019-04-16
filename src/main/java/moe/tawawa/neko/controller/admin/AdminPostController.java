package moe.tawawa.neko.controller.admin;

import moe.tawawa.neko.model.domain.Post;
import moe.tawawa.neko.model.enums.ErrorCode;
import moe.tawawa.neko.model.request.ListRequest;
import moe.tawawa.neko.model.request.PostCreateRequest;
import moe.tawawa.neko.model.request.PostUpdateRequest;
import moe.tawawa.neko.model.response.JsonResponse;
import moe.tawawa.neko.model.response.data.CreateData;
import moe.tawawa.neko.model.response.data.ListData;
import moe.tawawa.neko.model.response.data.VoidData;
import moe.tawawa.neko.model.vo.PostVO;
import moe.tawawa.neko.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @GetMapping("/list")
    public String list(@RequestParam(value = "page", defaultValue = "1") Integer page, Model model) {
        page = page < 0 ? 0 : page - 1;
        Page<Post> list = postService.findAllByPage(page, 10);
        if (!list.isFirst()) {
            model.addAttribute("hasPre", true);
            model.addAttribute("preNum", page);
        } else {
            model.addAttribute("preNum", false);
        }

        if (!list.isLast()) {
            model.addAttribute("hasNext", true);
            model.addAttribute("nextNum", page + 2);
        } else {
            model.addAttribute("hasNext", false);
        }
        model.addAttribute("posts", list.getContent());
        model.addAttribute("title", "文章管理/文章列表");
        return "admin/post/list";
    }

    @GetMapping(value = "/new")
    public String createPost(Model model) {
        model.addAttribute("title", "文章管理/创建文章");
        return "admin/post/edit";
    }

    @GetMapping(value = "/edit/{id}")
    public String updatePost(@PathVariable("id") Long id, Model model) {
        PostVO postVO = postService.getPostInfo(id);
        model.addAttribute("title", "文章管理/编辑文章");
        model.addAttribute("post", postVO);
        return "admin/post/edit";
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
