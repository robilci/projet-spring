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
import spring.core.entity.Member;
import spring.core.entity.Team;
import spring.core.repository.MemberRepository;
import spring.core.repository.TeamRepository;

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
    public CommandLineRunner demo(MemberRepository memberRepo, TeamRepository teamRepo) {
        return (args) -> {
            // save a few members
            memberRepo.save(new Member("Jack", "Bauer", "jack.bauer@gmail.com", "abcABC#@123"));
            memberRepo.save(new Member("John", "Wick", "john.wick@gmail.com", "abcABCddaa#@123"));
            teamRepo.save(new Team("informaticien"));

            // fetch all members
            System.out.println("Member found with findAll():");
            System.out.println("-------------------------------");
            for (Member member : memberRepo.findAll()) {
                System.out.println(member.toString());
            }

            // fetch an individual member by ID
            Member member = memberRepo.findById(1L);
            System.out.println("member found with findById(1L):");
            System.out.println(member.toString());
            
            for (Team team : teamRepo.findAll()) {
                System.out.println(team.toString());
            }

            System.out.println("--------------------------------------------");
            memberRepo.findByFirstname("Jack").forEach(bauer -> {
                System.out.println(bauer.toString());
            });
        };
    }

}
