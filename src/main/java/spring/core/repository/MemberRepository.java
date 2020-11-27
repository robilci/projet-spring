/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spring.core.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import spring.core.entity.Member;


/**
 *
 * @author robin
 */
public interface MemberRepository extends JpaRepository<Member, Long> {

    List<Member> findByFirstname(String firstname);
    Member findById(long id);
    
}
