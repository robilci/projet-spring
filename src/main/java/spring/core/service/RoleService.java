/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spring.core.service;

import java.util.List;
import java.util.Optional;
import spring.core.entity.Role;

/**
 *
 * @author robin
 */
public interface RoleService {
    Role save(Role entity);
    void delete(Long id);
    List<Role> findAll();
    Optional<Role> findById(Long id);
    Role getOne(Long id);
}
