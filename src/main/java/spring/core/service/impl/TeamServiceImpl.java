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
import spring.core.entity.Team;
import spring.core.repository.TeamRepository;
import spring.core.service.TeamService;

/**
 *
 * @author robin
 */

@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    private TeamRepository repo;

    @Override
    public Team save(Team entity) {
        return repo.save(entity);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }

    @Override
    public List<Team> findAll() {
        return (List<Team>) repo.findAll();
    }

    @Override
    public Optional<Team> findById(Long id) {
        return repo.findById(id);
    }

    @Override
    public Team getOne(Long id) {
        return repo.getOne(id);
    }
}
