/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spring.core.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import spring.core.entity.Domain;

/**
 *
 * @author robin
 */
public interface DomainRepository extends JpaRepository<Domain, Long>{
    List<Domain> findByName(String name);
    Domain findById(long id);
}
