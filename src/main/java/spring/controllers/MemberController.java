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
import spring.validator.MemberForm;

/**
 *
 * @author robin
 */
@Controller
public class MemberController {
    
    @Autowired
    private MemberService service;
    
    @GetMapping("member/create")
    public String createForm(MemberForm form){
        return "member/create";
    }
    
    @PostMapping("member/create")
    public String checkPersonInfo(@Valid MemberForm memberForm, BindingResult bindingResult) {
        
        if (bindingResult.hasErrors()) {
            return "member/create";
        }
        
        // TODO : si il ny a pas d'erreur, on génère un MDP et on crée le nouvel utilisateur puis on redirige avec un message de confirmation
        return "login";
    }
}
