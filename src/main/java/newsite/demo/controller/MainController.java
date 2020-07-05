package newsite.demo.controller;


import newsite.demo.entity.Post;
import newsite.demo.entity.User;
import newsite.demo.repository.PostRepository;
import newsite.demo.service.PostService;
import newsite.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Date;
import java.util.List;


@Controller
public class MainController {

    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

    @Autowired
    private PostRepository postRepository;


    @GetMapping("/")
    public String addPost(Model model){
       Iterable<Post>posts= postService.getAll();
        Collections.reverse((List<Post>) posts);
       model.addAttribute("posts",posts);

       User user=userService.getLoginUser();
       //User user=userService.findUserById(userId);
       model.addAttribute("user",user);
        return "main";
    }

    @PostMapping("/")
    public String addPost(@RequestParam String name, @RequestParam String text,@RequestParam String price,
                          @RequestParam String city,Model model){
        User user =userService.getLoginUser();
        Date time=new Date();
        Post post=new Post(name,text,city,price,time);
       // post.setUser(userService.findUserById(id));
        post.setUser(user);
        postService.save(post);
        //postService.addPost(name,text);

        return "main";
    }




}
