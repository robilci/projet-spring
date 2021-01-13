/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spring.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.core.entity.Demand;

/**
 *
 * @author robin
 */
public interface DemandReposiroty extends JpaRepository<Demand, Long>{
    
}
