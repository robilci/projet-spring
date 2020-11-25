/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spring.core.service;

import java.util.List;
import java.util.Optional;
import spring.core.entity.Member;

/**
 *
 * @author robin
 */
public interface MemberService {
    Member save(Member entity);
    void delete(Long id);
    List<Member> findAll();
    Optional<Member> findById(Long id);
    Member findByFirstname(String firstname);
    Member getOne(Long id);
}
