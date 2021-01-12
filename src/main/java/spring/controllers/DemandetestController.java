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
@RequestMapping("demande")
public class DemandetestController {
    
    @Autowired
    private UserService service;
    
    @Autowired
    private TeamService teamService;
    @Autowired
    private RoleService roleService;
    
    @GetMapping("/create")
    public String createForm(Model model){
        return "testauthdemande/create";
    }

    @GetMapping("/list")
    public String list(Model model){
        return "testauthdemande/list";
    }

}
