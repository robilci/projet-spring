/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spring.controllers;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import spring.core.entity.Member;
import spring.core.service.MemberService;
import spring.core.service.TeamService;

/**
 *
 * @author robin
 */
@Controller
@RequestMapping("member")
public class MemberController {
    
    @Autowired
    private MemberService service;
    
    @Autowired
    private TeamService teamService;
    
    @GetMapping("/create")
    public String createForm(Model model){
        
        model.addAttribute("member", new Member());
        model.addAttribute("teams", teamService.findAll());
        return "member/create";
    }
    
    @PostMapping("/create")
    public String createValid(@Valid Member member, BindingResult bindingResult) {
        
        member.setPassword("abcABC@11215");
        System.out.println("nb error = " + bindingResult.getAllErrors().size());
        
        if (bindingResult.hasErrors()) {
            return "member/create";
        }
        
        service.save(member);
        System.out.println(service.findByFirstname("Robin").toString());
        // TODO : si il ny a pas d'erreur, on génère un MDP et on crée le nouvel utilisateur puis on redirige avec un message de confirmation
        return "home";
    }
}
