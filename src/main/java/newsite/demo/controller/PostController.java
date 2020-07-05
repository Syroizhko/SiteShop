package newsite.demo.controller;


import newsite.demo.entity.Kind;
import newsite.demo.entity.Post;
import newsite.demo.entity.User;
import newsite.demo.service.PostService;
import newsite.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collections;
import java.util.Date;
import java.util.List;


@Controller
public class PostController {


    @Autowired
    private UserService userService;


    @Autowired
    private PostService postService;

    @GetMapping("/addPost/{id}")
    public String addPost(@PathVariable(value = "id")Long id, Model model){
        Iterable<Post>posts=postService.getAllByUserId(userService.getLoginUser().getId());
        Collections.reverse((List<Post>) posts);
        model.addAttribute("posts",posts);


        User user=userService.findUserById(id);
        model.addAttribute("user",user);
        return "addPost";
    }

    @PostMapping("/addPost/{id}")
    public String addPost(@PathVariable(value = "id")Long id, @RequestParam String name, @RequestParam String city, @RequestParam String price,
                          @RequestParam(name = "image")MultipartFile file, @RequestParam String text,@RequestParam String kind, Model model){
        User user =userService.getLoginUser();
        Date time=new Date();
        Post post=postService.addPost(name,text,city,price,time,file,kind);
        post.setUser(user);
        postService.save(post);
        return "redirect:/addPost/"+id;
    }


    @GetMapping("/addPost/{user.id}/edit/{post.id}")
    public String editPost(@PathVariable(value = "user.id")Long userid,@PathVariable(value = "post.id")Long postid, Model model){

        Post posts= postService.getPostById(postid);
        model.addAttribute("posts",posts);


        User user=userService.findUserById(userid);
        model.addAttribute("user",user);


        return "PostEdit";
    }

    @PostMapping("/addPost/{id}/edit/{post.id}")
    public String editPost(@PathVariable(value = "id")Long id,@PathVariable(value = "post.id")Long postid, @RequestParam String name,@RequestParam String text,
                          @RequestParam(name = "image")MultipartFile file,  Model model){
        User user =userService.getLoginUser();

        Date time =new Date ();

        Post post=postService.getOne(postid);
        if(name!=null && name!=""){
            post.setName(name);
        }
        if(text!=null && text!=""){
            post.setText(text);
        }
        post.setDate(time);
        post.setUser(user);

        postService.save(post);
        return "redirect:/addPost/"+id;
    }


    @GetMapping("/addPost/{id}/delete/{post.id}")
    public String deletePost(@PathVariable(name = "id") Long id,@PathVariable(name = "post.id") Long postid){
        postService.delete(postid);
        return "redirect:/addPost/"+id;
    }

    @GetMapping("/sort/{kind}")
    public String sort(@PathVariable(name = "kind")Kind kind,Model model){
        User user=userService.getLoginUser();
        model.addAttribute("user",user);

        Iterable<Post>posts=postService.getByKind(kind);
        model.addAttribute("posts",posts);
        return "main";
    }


    @PostMapping("/sort")
    public String sortPost(@RequestParam Kind kind ,Model model){
        //postService.getByKind(kind);

        return "redirect:/sort/"+kind;
    }

    @GetMapping("/find/{username}")
    public String find(@PathVariable(name = "username")String username,Model model){
        User user=userService.getLoginUser();
        model.addAttribute("user",user);

        Iterable<Post>posts=postService.getByUsername(username);
        model.addAttribute("posts",posts);
        return "main";
    }


    @PostMapping("/find")
    public String findPost(@PathVariable(name = "username")String username,Model model){
        //postService.getByKind(kind);
        //postService.getAllByUserId(id);

        return "redirect:/find/"+username;
    }


}
