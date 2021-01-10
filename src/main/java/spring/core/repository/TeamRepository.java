/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spring.core.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import spring.core.entity.Team;

/**
 *
 * @author robin
 */
public interface TeamRepository extends JpaRepository<Team, Long> {

    List<Team> findByName(String name);
    Team findById(long id);
    
}
