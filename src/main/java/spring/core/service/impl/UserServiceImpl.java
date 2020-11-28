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
import spring.core.entity.User;
import spring.core.repository.UserRepository;
import spring.core.service.UserService;

/**
 *
 * @author robin
 */
@Service
public class UserServiceImpl implements UserService {
    
    @Autowired
    private UserRepository repo;
            
    @Override
    public User save(User entity) {
        return repo.save(entity);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }

    @Override
    public List<User> findAll() {
        return (List<User>) repo.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return repo.findById(id);
    }

    @Override
    public User getOne(Long id) {
        return repo.getOne(id);
    }

    @Override
    public List<User> findByFirstname(String firstname) {
        return repo.findByFirstname(firstname);
    }
    
}
