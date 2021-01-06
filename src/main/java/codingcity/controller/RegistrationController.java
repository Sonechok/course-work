package codingcity.controller;

import codingcity.dto.UserDTO;
import codingcity.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class RegistrationController {
    private final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/registration")
    public String getLoginPage(Model model){
        model.addAttribute("user", new UserDTO());
        return "registration";
    }

    @PostMapping("/registration")
    public String getRegistrationPage(@ModelAttribute("user") @Valid UserDTO user, BindingResult result) {
        if(result.hasErrors()){
            return "registration";
        }
        userService.createUser(user);
        return "main";
    }
}
