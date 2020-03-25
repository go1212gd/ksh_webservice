package com.kshpart.www.springboot.web;

import com.kshpart.www.springboot.config.auth.LoginUser;
import com.kshpart.www.springboot.config.auth.dto.SessionUser;
import com.kshpart.www.springboot.service.PostsService;
import com.kshpart.www.springboot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;
    private final HttpSession httpSession;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user){
            //public String index(Model model){
        model.addAttribute("posts", postsService.findAllDesc());
        //addAttributes랑 헛갈리지 말자.
        //SessionUser user = (SessionUser) httpSession.getAttribute("user");
        // 개선 필요.
        if(user!=null){
            model.addAttribute("userName", user.getName());
        }
        return "index";
    }
//    @GetMapping("/")
//    public String index(){
//        return "index";
//    }

    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postUpdate(@PathVariable Long id, Model model){
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post",dto);
        return "posts-update";
    }

}
