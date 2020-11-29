/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import spring.core.entity.Role;
import spring.core.entity.User;
import spring.core.entity.Team;
import spring.core.repository.RoleRepository;
import spring.core.repository.TeamRepository;
import spring.core.repository.UserRepository;

/**
 *
 * @author robin
 */
@SpringBootApplication(scanBasePackages = "spring")
public class Application extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Bean
    public CommandLineRunner demo(UserRepository userRepo, TeamRepository teamRepo, RoleRepository roleRepo) {
        return (args) -> {
            
            // save a few user with team and role
            Team t = new Team("informaticien");
            teamRepo.save(t);
            
            Role r = new Role("Admin");
            roleRepo.save(r);

            userRepo.save(new User("jack", "bauer", "jack.bauer@gmail.com", "abcABC@123", t, r));

            // fetch all userss
            System.out.println("User found with findAll():");
            System.out.println("-------------------------------");
            for (User user : userRepo.findAll()) {
                System.out.println(user.toString());
            }
            
            for (Team team : teamRepo.findAll()) {
                System.out.println(team.toString());
            }

            System.out.println("--------------------------------------------");
            userRepo.findByFirstname("Jack").forEach(bauer -> {
                System.out.println(bauer.toString());
            });
        };
    }

}
