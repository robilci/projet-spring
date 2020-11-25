/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spring.controllers;

import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import spring.core.Login;
import spring.validator.MemberForm;

/**
 *
 * @author robin
 */
@Controller
public class UrlMapping {

    @GetMapping("/login")
    public String loginForm(Model model) {
        model.addAttribute("login", new Login());
        return "login";
    }

    @PostMapping("/login")
    public String loginSubmit(@ModelAttribute Login login, Model model) {
        // TODO : vérification du login et mot de passe dans la bdd
        // TODO : Si tout est OK démarage de la session Spring avec toute les données nécéssaires dedans
        // TODO : En fonction du rôle redirection vers une page
        System.out.println(login.getEmail() + " -  " + login.getPassword());
        return "login";
    }

    @GetMapping("/member/create")
    public String memberCreateForm(MemberForm memberForm) {
        return "member/create";
    }

    @PostMapping("/member/create")
    public String checkPersonInfo(@Valid MemberForm memberForm, BindingResult bindingResult) {
        
        if (bindingResult.hasErrors()) {
            return "member/create";
        }

        // TODO : si il ny a pas d'erreur, on génère un MDP et on crée le nouvel utilisateur puis on redirige avec un message de confirmation
        return "login";
        
    }

}
