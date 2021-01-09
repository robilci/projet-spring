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
import spring.core.entity.ModelDemand;
import spring.core.service.DomainService;
import spring.core.service.ModelDemandService;

/**
 *
 * @author robin
 */
@Controller
@RequestMapping("model")
public class ModelController {
    
    @Autowired
    private ModelDemandService modelService;
    
    @Autowired
    private DomainService domainService;
    
    @GetMapping("/create")
    public String createForm(Model model){
        
        model.addAttribute("modelDemand", new ModelDemand());
        model.addAttribute("domains", domainService.findAll());
        return "demand/model/create";
    }
    
    @PostMapping("/create")
    public String createForm(@Valid ModelDemand modelDemand, BindingResult bindingResult, Model model){
        
        if(!bindingResult.hasErrors()){
            modelService.save(modelDemand);
            return this.list(model);
        }
        
        return this.createForm(model);
    }
    
    @GetMapping("/list")
    public String list(Model model){
        
        model.addAttribute("models", modelService.findAll());
        
        return "demand/model/list";
    }      
}
