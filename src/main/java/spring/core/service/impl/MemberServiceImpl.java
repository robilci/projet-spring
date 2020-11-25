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
import spring.core.entity.Member;
import spring.core.repository.MemberRepository;
import spring.core.service.MemberService;

/**
 *
 * @author robin
 */
@Service
public class MemberServiceImpl implements MemberService {
    
    @Autowired
    private MemberRepository repo;
            
    @Override
    public Member save(Member entity) {
        return repo.save(entity);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }

    @Override
    public List<Member> findAll() {
        return (List<Member>) repo.findAll();
    }

    @Override
    public Optional<Member> findById(Long id) {
        return repo.findById(id);
    }

    @Override
    public Member findByFirstname(String firstname) {
        return repo.findByFirstname(firstname);
    }

    @Override
    public Member getOne(Long id) {
        return repo.getOne(id);
    }
    
}
