/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spring.core.service;

import java.util.List;
import spring.core.entity.ModelDemand;

/**
 *
 * @author robin
 */
public interface ModelDemandService {
    
    public ModelDemand save(ModelDemand entity);
    public List<ModelDemand> findAll();
}
