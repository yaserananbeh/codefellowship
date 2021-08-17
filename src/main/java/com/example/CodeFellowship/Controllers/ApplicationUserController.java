package com.example.CodeFellowship.Controllers;

import com.example.CodeFellowship.Models.ApplicationUser;
import com.example.CodeFellowship.Repos.ApplicaitonUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class ApplicationUserController {
    @Autowired
    ApplicaitonUserRepo applicaitonUserRepo;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @GetMapping("/signup")
    public String getSiginUpPage() {
        return "signup";
    }

    @PostMapping("/signup")
//    @ResponseBody
    public RedirectView signUp(@RequestParam(value = "username") String username,
                               @RequestParam(value = "password") String password,
                               @RequestParam(value = "firstname") String firstname,
                               @RequestParam(value = "lastname") String lastname,
                               @RequestParam(value = "dateofbirth") String dateofbirth,
                               @RequestParam(value = "bio") String bio, Model model) {
        ApplicationUser newUser=new ApplicationUser(username,bCryptPasswordEncoder.encode(password),firstname,
                lastname,dateofbirth,bio);
        if(applicaitonUserRepo.findByUsername(username)==null){
        applicaitonUserRepo.save(newUser);
        model.addAttribute("users",applicaitonUserRepo.findAll());

        return new RedirectView("/perform_login");
        }
        else{
            System.out.println("the user is already exist in our website");
            return new RedirectView("/login");
        }
    }
    @GetMapping("/login")
    public String getLoginForm() {
        return "loginform";
    }


}
