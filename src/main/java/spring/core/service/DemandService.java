/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spring.core.service;

import java.util.List;
import spring.core.entity.Demand;

/**
 *
 * @author robin
 */
public interface DemandService {
    
    List<Demand> findAll();
    Demand save(Demand demand);
    Demand getOne(Long id);
    
}
