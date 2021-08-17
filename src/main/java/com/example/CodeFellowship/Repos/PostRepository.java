package com.example.CodeFellowship.Repos;

import com.example.CodeFellowship.Models.ApplicationUser;
import com.example.CodeFellowship.Models.Post;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostRepository extends CrudRepository<Post, Integer> {
    List<Post> findAllByUser(ApplicationUser applicationUser);
}
