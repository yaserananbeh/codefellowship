package com.example.CodeFellowship;

import com.example.CodeFellowship.Models.ApplicationUser;
import com.example.CodeFellowship.Repos.ApplicaitonUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImp implements UserDetailsService {
    @Autowired
    ApplicaitonUserRepo applicaitonUserRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ApplicationUser applicationUser=applicaitonUserRepo.findByUsername(username);

        //Error Handling if the user doesn't exist in the database
        //if the applicationUser null
        if(applicationUser ==null){
            throw new UsernameNotFoundException("The user "+ username+" doesn't exist ");
        }
        return applicationUser;

    }
}
