package com.example.TravelGuide.repo;

import com.example.TravelGuide.models.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository <Post, Long> {
}
