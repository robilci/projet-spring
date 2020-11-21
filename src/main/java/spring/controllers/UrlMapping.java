/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import spring.classes.Login;

/**
 *
 * @author robin
 */
@Controller
public class UrlMapping {

    @GetMapping("/login")
    public String loginForm(Model model){
        model.addAttribute("login", new Login());
        return "login";
    }
    
    @PostMapping("/login")
    public String loginSubmit(@ModelAttribute Login login, Model model){
        // TODO : vérification du login et mot de passe dans la bdd
        // TODO : Si tout est OK démarage de la session Spring
        // TODO : En fonction du rôle redirection vers une page
        System.out.println(login.getEmail() + " -  " + login.getPassword());
        return "login"; 
    }
    
    @GetMapping("/member/create")
    public String memberCreateForm(Model model){
        return "member/create";
    }
    
    
}
