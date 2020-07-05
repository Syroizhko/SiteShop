package newsite.demo.controller;


import newsite.demo.dto.UserDto;
import newsite.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private UserService userService;


    @ModelAttribute("user")
    public UserDto getModel(){
        return new UserDto();
    }

    @GetMapping("/logout")
    public String logout(){
        return "login";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/registration")
    public String getRegistration(){
        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("user")UserDto userDto, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return "registration";
        userService.registration(userDto);
        return "redirect:/login";
    }

}
