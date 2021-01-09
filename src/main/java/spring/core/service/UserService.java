/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spring.core.service;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;
import spring.core.entity.User;

/**
 *
 * @author robin
 */
public interface UserService {
    User save(User entity) throws ParseException;
    void delete(Long id);
    List<User> findAll();
    Optional<User> findById(Long id);
    List<User> findByFirstname(String firstname);
    User getOne(Long id);
    User findByPasswordAndEmail(String password, String email);

}
