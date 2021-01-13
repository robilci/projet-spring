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
import spring.core.entity.Team;
import spring.core.entity.User;
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
@RequestMapping("team")
public class TeamController {
    
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
    
    @GetMapping("/create")
    public String createForm(Model model){
        
        model.addAttribute("team", new Team());
       // model.addAttribute("teams", teamService.findAll());
        //model.addAttribute("roles", roleService.findAll());
        return "team/create";
    }

    @GetMapping("/list")
    public String userlist(Model model){
        model.addAttribute("teams", teamRepository.findAll());
        return "team/list";
    }
    
    @PostMapping("/create")
    public String createValid(@Valid Team team, BindingResult bindingResult, Model model) throws ParseException {
        System.out.println("nb error = " + bindingResult.getAllErrors().size());
        if (bindingResult.hasErrors()) {
            return "team/create";
        }
        teamRepository.save(team);
        return this.userlist(model);
    }

    @RequestMapping("/teammember/{id}")
    public String Teammember(@PathVariable("id") Long id, Model model) throws ParseException {
        //System.out.println("nb error = " + bindingResult.getAllErrors().size());
        /*if (bindingResult.hasErrors()) {
            return "team/list";
        }
        */
        model.addAttribute("users",userRepository.findByTeam(teamRepository.findById(id).get()));
        //model.addAttribute("users",service.findAll());
        return "team/listmembre";
    }

}
