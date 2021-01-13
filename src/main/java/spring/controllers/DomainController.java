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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import spring.core.entity.Domain;
import spring.core.entity.Team;
import spring.core.repository.DomainRepository;
import spring.core.repository.TeamRepository;
import spring.core.repository.UserRepository;
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
@RequestMapping("domain")
public class DomainController {
    
    @Autowired
    private UserService service;
    
    @Autowired
    private TeamService teamService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private TeamRepository teamRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private DomainRepository domainRepository;
    
    @GetMapping("/create")
    public String createForm(Model model){
        
        model.addAttribute("domain", new Domain());
       // model.addAttribute("teams", teamService.findAll());
        //model.addAttribute("roles", roleService.findAll());
        return "domain/create";
    }

    @GetMapping("/list")
    public String userlist(Model model){
        model.addAttribute("domains", domainRepository.findAll());
        return "domain/list";
    }
    
    @PostMapping("/create")
    public String createValid(@Valid Domain domain, BindingResult bindingResult, Model model) throws ParseException {
        System.out.println("nb error = " + bindingResult.getAllErrors().size());
        if (bindingResult.hasErrors()) {
            return "domain/create";
        }
        domainRepository.save(domain);
        return this.userlist(model);
    }



}
