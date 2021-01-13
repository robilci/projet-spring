/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spring.core.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.core.entity.Demand;
import spring.core.repository.DemandReposiroty;
import spring.core.service.DemandService;

/**
 *
 * @author robin
 */
@Service
public class DemandServiceImpl implements DemandService{
    
    @Autowired
    private DemandReposiroty repo;

    @Override
    public List<Demand> findAll() {
        return (List<Demand>) repo.findAll();
    }

    @Override
    public Demand save(Demand demand) {
        return repo.save(demand);
    }

    @Override
    public Demand getOne(Long id) {
        return repo.getOne(id);
    }
    
}
