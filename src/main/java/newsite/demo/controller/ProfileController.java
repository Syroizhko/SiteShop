package newsite.demo.controller;


import newsite.demo.entity.User;
import newsite.demo.repository.UserRepository;
import newsite.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ProfileController {

    @Autowired
    private UserService userService;


    @Autowired
    private UserRepository userRepository;


    @GetMapping("/profile/{id}")
    public String myProfile(@PathVariable(value = "id")Long id,Model model){

        //User user =userService.getLoginUser();
        User user = userService.findUserById(id);
        model.addAttribute("user",user);
        return "profile";
    }


    @PostMapping("/profile/{id}")
    public  String myProfile(@PathVariable(value = "id")Long id, @RequestParam(name = "image")MultipartFile file, Model model){

        //userService.findUserById(id);
        userService.getLoginUser();
        userService.addAvatar(file);
        return "redirect:/profile/"+id;
    }

    @GetMapping("/profile/{id}/edit")
    public String myProfileEdit(Model model){
        User user =userService.getLoginUser();
        model.addAttribute("user",user);
        return "profileEdit";
    }


    @PostMapping("/profile/{id}/edit")
    public  String myProfileUpdate(@PathVariable(value = "id")Long id,
                                   @RequestParam String username,@RequestParam String surname,@RequestParam String male,
                                   @RequestParam String phone,@RequestParam String country,Model model){

        User user=userService.findUserById(id);
        user.setUsername(username);
        user.setSurname(surname);
        user.setMale(male);
        user.setPhone(phone);
        user.setCountry(country);

        userService.save(user);
        return "redirect:/profile/{id}";
    }
}
