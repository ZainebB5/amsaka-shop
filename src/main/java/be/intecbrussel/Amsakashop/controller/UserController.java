package be.intecbrussel.Amsakashop.controller;

import be.intecbrussel.Amsakashop.data.User;
import be.intecbrussel.Amsakashop.repository.UserRepository;
import be.intecbrussel.Amsakashop.security.SecurityBeans;
import be.intecbrussel.Amsakashop.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private SecurityBeans securityBeans;

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
        if(userService.getUserByUserNameAndPassword(userReceived.getUserName(), userReceived.getPassWord()) != null){
            httpSession.setAttribute("loggedInUserName", userReceived.getUserName());
            return "redirect:/";
        }else{
            return "redirect:/register";
        }
    }

    @GetMapping("/register")
    public String registerGet(){
        return "register";
    }



    @PostMapping("/register")
    public String registerPost(@ModelAttribute("user")User user, HttpServletRequest request) throws ServletException{
        user.setPassWord(passwordEncoder.encode(user.getPassWord()));
        user.setRole("ROLE_USER");
        userRepository.save(user);
        request.login(user.getMail(), user.getPassWord());
        return "redirect:/products";

    }
}
