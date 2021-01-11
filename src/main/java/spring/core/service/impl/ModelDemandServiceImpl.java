/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spring.core.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.core.entity.ModelDemand;
import spring.core.repository.ModelRepository;
import spring.core.service.ModelDemandService;

/**
 *
 * @author robin
 */

@Service
public class ModelDemandServiceImpl implements ModelDemandService {
    
    @Autowired
    private ModelRepository repo;

    @Override
    public ModelDemand save(ModelDemand entity) {
        return repo.save(entity);
    }

    @Override
    public List<ModelDemand> findAll() {
        return repo.findAll();
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }


}
