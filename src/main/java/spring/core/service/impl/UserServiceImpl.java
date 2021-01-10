/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spring.core.service.impl;

<<<<<<< HEAD
=======
import java.text.ParseException;
>>>>>>> ca810f9ea47dc8a3801025d933b787d364d926c1
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
<<<<<<< HEAD
import spring.core.entity.User;
import spring.core.repository.UserRepository;
import spring.core.service.UserService;
=======
import org.springframework.transaction.annotation.Transactional;
import spring.core.entity.User;
import spring.core.repository.UserRepository;
import spring.core.service.EmailService;
import spring.core.service.UserService;
import spring.utils.Emailconfig;
>>>>>>> ca810f9ea47dc8a3801025d933b787d364d926c1

/**
 *
 * @author robin
 */
<<<<<<< HEAD
@Service
public class UserServiceImpl implements UserService {
=======
@Transactional
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private EmailServiceImpl emailService;
>>>>>>> ca810f9ea47dc8a3801025d933b787d364d926c1
    
    @Autowired
    private UserRepository repo;
            
    @Override
<<<<<<< HEAD
    public User save(User entity) {
=======
    public User save(User entity) throws ParseException {
        String mdp =  "abcABC@11215";
        entity.setPassword(mdp);
        emailService.EnvoieMotdePasse(entity,mdp);
>>>>>>> ca810f9ea47dc8a3801025d933b787d364d926c1
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

    @Override
    public User findByPasswordAndEmail(String password, String email) {
        return repo.findByPasswordAndEmail(password, email);
    }
    
}
