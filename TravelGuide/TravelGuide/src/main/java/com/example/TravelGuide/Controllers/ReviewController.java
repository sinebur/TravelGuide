package com.example.TravelGuide.Controllers;

import com.example.TravelGuide.models.Post;
import com.example.TravelGuide.repo.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class ReviewController {

    @Autowired
    private PostRepository postRepository;
    @GetMapping("/reviews")
    public String reviewPage (Model model){
        Iterable<Post> posts = postRepository.findAll();
        model.addAttribute("posts", posts);
        return "reviews";
    }

    @GetMapping("/reviews/add")
    public String reviewAdd (Model model){
        return "review-add";
    }

    @PostMapping("/reviews/add")
    public String reviewPostAdd(@RequestParam String title,@RequestParam String anons,@RequestParam String full_text, Model model){
        Post post = new Post(title, anons, full_text); //Create object
        postRepository.save(post); // saving object according to class post
        return "redirect:/reviews";
    }


    @GetMapping("/reviews/{id}") // {} dynamical parameter
    public String reviewDetails(@PathVariable(value = "id") Long id, Model model) { // to get dynamical param from url we use @Pathvariable
        if(!postRepository.existsById(id)){
            return "redirect:/reviews";
        }

        Optional<Post> post = postRepository.findById(id);
        ArrayList <Post> res = new ArrayList<>();
        post.ifPresent(res::add);
        model.addAttribute("post", res);
        return "review-details";
    }

    //edit
    @GetMapping("/reviews/{id}/edit") // {} dynamical parameter
    public String reviewEdit(@PathVariable(value = "id") Long id, Model model) { // to get dynamical param from url we use @Pathvariable
        if(!postRepository.existsById(id)){
            return "redirect:/reviews";
        }

        Optional<Post> post = postRepository.findById(id);
        ArrayList <Post> res = new ArrayList<>();
        post.ifPresent(res::add);
        model.addAttribute("post", res);
        return "review-edit";
    }

    @PostMapping("/reviews/{id}/edit")
    public String reviewPostUpdate(@PathVariable(value = "id") long id,@RequestParam String title,@RequestParam String anons,@RequestParam String full_text, Model model){
        Post post = postRepository.findById(id).orElseThrow();
        post.setTitle(title);
        post.setAnons(anons);
        post.setFull_text(full_text);
        postRepository.save(post);
        return "redirect:/reviews";
    }
    @PostMapping("/reviews/{id}/remove")
    public String reviewPostDelete(@PathVariable(value = "id") long id, Model model){
        Post post = postRepository.findById(id).orElseThrow();
        postRepository.delete(post);
        return "redirect:/reviews";
    }
}
