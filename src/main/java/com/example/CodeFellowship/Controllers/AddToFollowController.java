package com.example.CodeFellowship.Controllers;

import com.example.CodeFellowship.Repos.ApplicaitonUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

@Controller
public class AddToFollowController {
    @Autowired
    ApplicaitonUserRepo applicaitonUserRepo;
    @GetMapping("/followuser/{id}")
    @ResponseBody
    public String followUser(@PathVariable int id, Principal principal){

//        System.out.println("the user to follow "+applicaitonUserRepo.findById(id).get());
//        System.out.println("the sign in user "+principal.getName());
        return "test";
    }

}
