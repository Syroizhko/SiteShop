package newsite.demo.controller;


import newsite.demo.entity.Post;
import newsite.demo.entity.Role;
import newsite.demo.entity.User;
import newsite.demo.service.PostService;
import newsite.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;



@Controller
@PreAuthorize("hasAuthority('ROLE_ADMIN')")
public class AdminController {

    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/admin")
    public String AdminMain(Model model){
        User user=userService.getLoginUser();
        //User user=userService.findUserById(userId);
        model.addAttribute("user",user);

        Iterable<User>users= userService.getAll();
        //Collections.reverse((List<Post>) posts);
        model.addAttribute("users",users);
        return "AdminMain";
    }


    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/admin/All")
    public String adminAll(Model model){


        return "adminAll";
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/admin/delete/{id}")
    public String deleteUser(@PathVariable(name = "id") Long id){
        userService.delete(id);
        return "redirect:/admin";
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/delete/{id}")
    public String deletePost(@PathVariable(name = "id") Long id){
        postService.delete(id);
        return "redirect:/";
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/setAdmin/{id}")
    public String setAdmin(@PathVariable(name = "id") Long id){
        User user=userService.findUserById(id);
        user.setRole(Role.ADMIN);
        userService.save(user);
        return "redirect:/admin";
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/setUser/{id}")
    public String setUser(@PathVariable(name = "id") Long id){
        User user=userService.findUserById(id);
        user.setRole(Role.USER);
        userService.save(user);
        return "redirect:/admin";
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("admin/edit/{id}")
    public String editUser(@PathVariable(name = "id") Long id,Model model){
        User user =userService.findUserById(id);
        model.addAttribute("user",user);
        return "editUser";
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("admin/edit/{id}")
    public String editUsers(@PathVariable(name = "id") Long id, @RequestParam String surname, @RequestParam String male,
                            @RequestParam String phone, @RequestParam String country, @RequestParam String email){
        User user=userService.findUserById(id);
         user.setSurname(surname);
         user.setEmail(email);
         user.setMale(male);
         user.setPhone(phone);
         user.setCountry(country);
        userService.save(user);
        return "redirect:/admin";
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("{id}/edit/{post.id}")
    public String editPostAdm(@PathVariable(value = "id")Long id,@PathVariable(value = "post.id")Long postid, Model model){

//        User user =userService.findUserById(id);
//        model.addAttribute("user",user);

        Post posts= postService.getPostById(postid);
        model.addAttribute("posts",posts);

        return "PostEditAdm";
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("/edit/{post.id}")
    public String editPostAdm( @PathVariable(value = "post.id")Long postid, @RequestParam String name, @RequestParam String text,
                           @RequestParam(name = "image")MultipartFile file,@RequestParam String city,
                               @RequestParam String price, Model model){

        Date time =new Date ();

        Post post=postService.getOne(postid);
        if(name!=null && name!=""){
            post.setName(name);
        }
        if(text!=null && text!=""){
            post.setText(text);
        }
        if(text!=null && text!=""){
            post.setCity(city);
        }
        if(text!=null && text!=""){
            post.setPrice(price);
        }

        postService.save(post);
        return "redirect:/";
    }

}
