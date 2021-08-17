package com.example.CodeFellowship.Controllers;

import com.example.CodeFellowship.Models.ApplicationUser;
import com.example.CodeFellowship.Repos.ApplicaitonUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class profileController {
    @Autowired
    ApplicaitonUserRepo applicaitonUserRepo;
    @GetMapping("/profile")
    public String getProfilePage(@AuthenticationPrincipal ApplicationUser user, Model model){
        ApplicationUser userInfo=applicaitonUserRepo.findByUsername(user.getUsername());
        model.addAttribute("userInfo",userInfo);
        return "profile";
    }

}
