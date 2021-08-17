package com.example.CodeFellowship.Controllers;

import com.example.CodeFellowship.Models.ApplicationUser;
import com.example.CodeFellowship.Models.Post;
import com.example.CodeFellowship.Repos.ApplicaitonUserRepo;
import com.example.CodeFellowship.Repos.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.List;

@Controller
public class IndexController {
    @Autowired
    ApplicaitonUserRepo applicaitonUserRepo;
    @Autowired
    PostRepository postRepository;
    @GetMapping("/")
    public String indexController(Principal principal, Model model){
        if (principal!=null){
            ApplicationUser userInfo = applicaitonUserRepo.findByUsername(principal.getName());
            model.addAttribute("userId",userInfo.getId());
            model.addAttribute("userUserName",userInfo.getUsername());
            model.addAttribute("userFirstName",userInfo.getFirstName());
            model.addAttribute("userLastName",userInfo.getLastName());
            model.addAttribute("userDateOfBirth",userInfo.getDateOfBirth());
            model.addAttribute("userBio",userInfo.getBio());
            List<Post> postList =  postRepository.findAllByUser(userInfo);
            model.addAttribute("postList" , postList );
        }
        return "index";
    }

}
