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
import spring.core.service.DomainService;
import spring.core.service.UserService;

/**
 *
 * @author robin
 */
@Controller
public class AuthenticationController {

    @Autowired
    private ModelController modelController;

    @Autowired
    private UserService userService;
    
    @Autowired
    private DomainService domainService;

    @GetMapping("/dev")
    public String dev(Model model, HttpSession session) {
        return "demand/model/create";
    }

    @GetMapping("/")
    public String loginForm(Model model, HttpSession session) {
        return loginForm2(model, session);
    }

    @GetMapping("/login")
    public String loginForm2(Model model, HttpSession session) {
        if (session != null) {
            if (session.getAttribute("role") != null) {
                return this.modelController.list(model);
            }
        }
        model.addAttribute("login", new Login());

        return "login";
    }

    @GetMapping("/logout")
    public String logout(Model model, HttpSession session) {
        session.invalidate();
        model.addAttribute("logout", "Vous avez été déconnecté avec succès");
        model.addAttribute("login", new Login());
        
        return "redirect:http://localhost:8080/login";
    }

    @PostMapping("/login")
    public String loginSubmit(@ModelAttribute Login login, Model model, HttpSession session) {
        
        User user = userService.findByPasswordAndEmail(login.getPassword(), login.getEmail());

        if (user == null) {
            model.addAttribute("error", "1");
            session.invalidate();
            return "login";
        } else {
            model.addAttribute("error", "0");
            session.setAttribute("firstname", user.getFirstname());
            session.setAttribute("lastname", user.getLastname());
            session.setAttribute("role", user.getRole().getName());
            session.setAttribute("id", user.getId());
            return this.modelController.list(model);
        }
    }

}
