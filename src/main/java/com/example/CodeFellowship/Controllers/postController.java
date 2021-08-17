package com.example.CodeFellowship.Controllers;

import com.example.CodeFellowship.Models.*;
import com.example.CodeFellowship.Repos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class postController {
    @Autowired
    ApplicaitonUserRepo applicaitonUserRepo;

    @Autowired
    PostRepository postRepository;
    @PostMapping("/addpost")
    public RedirectView addPost(@AuthenticationPrincipal ApplicationUser user, @RequestParam String body){
        ApplicationUser userInfo = applicaitonUserRepo.findByUsername(user.getUsername());
        Post addNewPost = new Post(body , userInfo);
        postRepository.save(addNewPost);
        return new RedirectView("/profile");
    }
}
