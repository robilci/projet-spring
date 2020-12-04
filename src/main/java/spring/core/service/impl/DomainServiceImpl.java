/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spring.core.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.core.entity.Domain;
import spring.core.repository.DomainRepository;
import spring.core.service.DomainService;

/**
 *
 * @author robin
 */

@Service
public class DomainServiceImpl implements DomainService{
    
    @Autowired
    private DomainRepository repo;

    @Override
    public Domain save(Domain entity) {
        return repo.save(entity);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }

    @Override
    public List<Domain> findAll() {
        return (List<Domain>) repo.findAll();
    }

    @Override
    public Optional<Domain> findById(Long id) {
        return repo.findById(id);
    }

    @Override
    public Domain getOne(Long id) {
        return repo.getOne(id);
    }
   
}
