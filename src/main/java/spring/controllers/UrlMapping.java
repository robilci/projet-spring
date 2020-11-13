/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author robin
 */
@Controller
public class UrlMapping {

    @GetMapping("/login")
    public String loginView(){
        return "login";
    }
    
    @PostMapping("/login")
    public String loginPost(){
        return "login";
    }
    
    
}
