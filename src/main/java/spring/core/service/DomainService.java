/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spring.core.service;

import java.util.List;
import java.util.Optional;
import spring.core.entity.Domain;

/**
 *
 * @author robin
 */
public interface DomainService {
    Domain save(Domain entity);
    void delete(Long id);
    List<Domain> findAll();
    Optional<Domain> findById(Long id);
    Domain getOne(Long id);
}
