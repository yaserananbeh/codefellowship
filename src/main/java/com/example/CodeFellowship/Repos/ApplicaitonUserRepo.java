package com.example.CodeFellowship.Repos;

import com.example.CodeFellowship.Models.ApplicationUser;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ApplicaitonUserRepo extends CrudRepository<ApplicationUser,Integer> {
    public ApplicationUser findByUsername(String username);
}
