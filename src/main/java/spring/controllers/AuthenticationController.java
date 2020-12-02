/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spring.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import spring.classes.Login;
import spring.core.entity.User;
import spring.core.repository.UserRepository;
import spring.core.service.UserService;

/**
 *
 * @author robin
 */
@Controller
public class AuthenticationController {
    
    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String loginForm(Model model, HttpSession session) {
        
        model.addAttribute("login", new Login());
        return "login";
    }
    
    @GetMapping("/logout")
    public String logout(Model model, HttpSession session) {
        session.invalidate();
        model.addAttribute("login", new Login());
        return "login";
    }

    @PostMapping("/login")
    public String loginSubmit(@ModelAttribute Login login, Model model, HttpSession session) {
        
        User user = userService.findByPasswordAndEmail(login.getPassword(), login.getEmail());
        
        if(user == null){
            model.addAttribute("error", "Email ou mot de passe incorrect");
            session.invalidate();
            return "login";
        } else {
            session.setAttribute("firstname", user.getFirstname());
            session.setAttribute("lastname", user.getLastname());
            session.setAttribute("role", user.getRole().getName());
            return "home";
        }  
    }

}
