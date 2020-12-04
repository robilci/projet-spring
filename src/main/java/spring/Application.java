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
import spring.core.entity.Domain;
import spring.core.entity.Role;
import spring.core.entity.User;
import spring.core.entity.Team;
import spring.core.repository.DomainRepository;
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
    public CommandLineRunner demo(UserRepository userRepo, TeamRepository teamRepo, RoleRepository roleRepo, DomainRepository domainRepo) {
        return (args) -> {

            // save a few user with team and role
            /*Team t = new Team("informaticien");
            teamRepo.save(t);
            
            Role r = new Role("Admin");
            roleRepo.save(r);

            userRepo.save(new User("jack", "bauer", "jack.bauer@gmail.com", "abcABC@123", t, r));*/
            
            /*Domain domain1 = new Domain("Informatique");
            Domain domain2 = new Domain("Réseaux et internet");
            domainRepo.save(domain1);
            domainRepo.save(domain2);*/
            
            // fetch all userss
            System.out.println("User found with findByPasswordAndEmail():");
            System.out.println("-------------------------------");

            User user = userRepo.findByPasswordAndEmail("abcABC@123", "jack.bauer@gmail.com");
            if (user == null) {
                System.out.println("Utilisateur introuvable");
            } else {
                System.out.println(user.toString());
            }
        };
    }

}
