package codingcity.controller;

import codingcity.dto.UserDTO;
import codingcity.entity.User;
import codingcity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
public class MoneyController {
    private final UserService userService;

    @Autowired
    public MoneyController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/cabinet/money")
    public String getMoneyPage(Model model){
        return "money";
    }


    @PostMapping("/cabinet/money")
    public String createTransaction(@ModelAttribute(name = "user") UserDTO u, Principal principal) {
        String email = principal.getName();
        User user = userService.findUserByEmail(email);
        userService.updateAmountOfMoney(user, u.getAmountOfMoney());
        return "main";
    }
}
