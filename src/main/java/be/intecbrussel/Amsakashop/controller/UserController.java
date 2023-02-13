package be.intecbrussel.Amsakashop.controller;

import be.intecbrussel.Amsakashop.data.User;
import be.intecbrussel.Amsakashop.services.interfaces.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    private UserService userService;

    @GetMapping("/login")
    public String goToLoginPage(HttpSession httpSession){

        if (httpSession.getAttribute("loggedInUserName")==null){
            return "login";
        }
        else {
            return "redirect:/products";
        }
    }

    @PostMapping(("/login"))
    public String login(User userReceived, HttpSession httpSession){
        System.out.println(userReceived);
        if(userService.getUserByMailAndPassword(userReceived.getMail(), userReceived.getPassWord()) != null){
            httpSession.setAttribute("loggedInUserName", userReceived.getMail());
            return "redirect:/products";
        }else{
            return "redirect:/login";
        }

    }
}
