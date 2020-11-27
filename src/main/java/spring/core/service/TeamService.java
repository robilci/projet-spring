/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spring.core.service;

import java.util.List;
import java.util.Optional;
import spring.core.entity.Team;

/**
 *
 * @author robin
 */
public interface TeamService {
    Team save(Team entity);
    void delete(Long id);
    List<Team> findAll();
    Optional<Team> findById(Long id);
    Team getOne(Long id);
}
