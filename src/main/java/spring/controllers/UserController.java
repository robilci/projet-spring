/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import spring.core.entity.User;
import spring.core.service.RoleService;
import spring.core.service.TeamService;
import spring.core.service.UserService;

import javax.validation.Valid;
import java.text.ParseException;

/**
 *
 * @author robin
 */
@Controller
@RequestMapping("user")
public class UserController {
    
    @Autowired
    private UserService service;
    
    @Autowired
    private TeamService teamService;
    @Autowired
    private RoleService roleService;
    
    @GetMapping("/create")
    public String createForm(Model model){
        
        model.addAttribute("user", new User());
        model.addAttribute("teams", teamService.findAll());
        model.addAttribute("roles", roleService.findAll());
        return "user/create";
    }

    @GetMapping("/list")
    public String userlist(Model model){

        model.addAttribute("users", service.findAll());
        return "user/list";

    }
    
    @PostMapping("/create")
    public String createValid(@Valid User user, BindingResult bindingResult, Model model) throws ParseException {

        //String mdp = "abcABC@11215";
        //user.setPassword("abcABC@11215");
        System.out.println("nb error = " + bindingResult.getAllErrors().size());
        if (bindingResult.hasErrors()) {
            return "user/create";
        }
        service.save(user);
        //System.out.println(service.findByFirstname("Robin").toString());
        // TODO : si il ny a pas d'erreur, on génère un MDP et on crée le nouvel utilisateur puis on redirige avec un message de confirmation
        return this.userlist(model);
    }
}
