package com.example.CodeFellowship.Controllers;

import com.example.CodeFellowship.Repos.ApplicaitonUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class findUsersController {
    @Autowired
    ApplicaitonUserRepo applicaitonUserRepo;

    @GetMapping("/findUsers")
    public String showAllUsers(Model model, Principal principal){
        model.addAttribute("signedUserId",applicaitonUserRepo.findByUsername(principal.getName()).getId());
        model.addAttribute("users",applicaitonUserRepo.findAll());
        return "showUsers";
    }
}
