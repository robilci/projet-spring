/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spring.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import spring.core.entity.Demand;
import spring.core.entity.ModelDemand;
import spring.core.repository.DemandReposiroty;
import spring.core.service.DomainService;
import spring.core.service.ModelDemandService;
import spring.core.service.impl.DemandServiceImpl;

/**
 *
 * @author robin
 */

@Controller
@RequestMapping("demand")
public class DemandController {
    
    @Autowired
    private DemandServiceImpl demandService;
    
    @Autowired
    private ModelDemandService modelService;
    
    @Autowired
    private DomainService domainService;
    
    private ModelDemand chosenModel;
    
    @GetMapping("/create/{id}")
    public String createForm(@PathVariable(value="id") String id, Model model) {
        model.addAttribute("demand", new Demand());
        chosenModel = modelService.getOne(Long.parseLong(id));
        model.addAttribute("model", chosenModel);
        return "demand/create";
    }

    @GetMapping("/list")
    public String list(Model model){
        
        model.addAttribute("models", modelService.findAll());
        
        return "demand/list";
    }
    
    @PostMapping("/create")
    public String createDemand(@Valid Demand demand, BindingResult bindingResult, Model model){
        
        if(!bindingResult.hasErrors()){
            Date date = new Date();
            demand.setPriority(chosenModel.getPriority());
            demand.setTitle(chosenModel.getTitle());
            demand.setType(chosenModel.getType());
            demand.setLocation(chosenModel.getLocation());
            demand.setCreationDate(date);
            demand.setStatus(1);
            System.out.println("AUTOWIRED : " + demandService.toString());
            demandService.save(demand);
            return this.myList(model);
        }
        
        return this.createForm(chosenModel.getId() + "", model);
    }
    
    @GetMapping("/mylist")
    public String myList(Model model){
        
        model.addAttribute("demands", demandService.findAll());
        
        return "demand/mylist";
    }
    
    @GetMapping("/{id}")
    public String getOne(@PathVariable(value="id") String id, Model model){
        
        SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss");
        Demand demand = demandService.getOne(Long.parseLong(id));     
        Date date = demand.getCreationDate();
        model.addAttribute("demand", demand);
        String dateStr = s.format(date);
        model.addAttribute("date", dateStr);
        return "demand/one";
    }
}
