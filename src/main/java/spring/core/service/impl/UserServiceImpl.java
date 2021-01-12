/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spring.core.service.impl;


import java.text.ParseException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.core.entity.User;
import spring.core.repository.UserRepository;
import spring.core.service.EmailService;
import spring.core.service.UserService;
import spring.utils.Emailconfig;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author robin
 */

@Transactional
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private EmailServiceImpl emailService;

    
    @Autowired
    private UserRepository repo;

    public String generate(int length)
    {
        String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890"; // Tu supprimes les lettres dont tu ne veux pas
        String pass = "";
        for(int x=0;x<length;x++)
        {
            int i = (int)Math.floor(Math.random() * 62); // Si tu supprimes des lettres tu diminues ce nb
            pass += chars.charAt(i);
        }
        System.out.println(pass);
        return pass;
    }
            
    @Override
    public User save(User entity) throws ParseException {
        String mdp =  generate(6);
        //j'ai enlevé la contrainte sur les users
        String mdpcript = new BCryptPasswordEncoder().encode(mdp);
        entity.setPassword(mdpcript);
        emailService.EnvoieMotdePasse(entity,mdp);
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
