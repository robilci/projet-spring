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
import spring.core.entity.Role;
import spring.core.repository.RoleRepository;
import spring.core.service.RoleService;

/**
 *
 * @author robin
 */
@Service
public class RoleServiceImpl implements RoleService {
    
    @Autowired
    private RoleRepository repo;

    @Override
    public Role save(Role entity) {
        return repo.save(entity);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }

    @Override
    public List<Role> findAll() {
        return (List<Role>) repo.findAll();
    }

    @Override
    public Optional<Role> findById(Long id) {
        return repo.findById(id);
    }

    @Override
    public Role getOne(Long id) {
        return repo.getOne(id);
    }

}
