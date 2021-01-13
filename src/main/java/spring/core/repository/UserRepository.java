/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spring.core.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import spring.core.entity.Team;
import spring.core.entity.User;


/**
 *
 * @author robin
 */
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByFirstname(String firstname);
    User findById(long id);
    User findByPasswordAndEmail(String password, String email);
    List<User>  findByTeam(Team team);
    
}
