/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spring;

import java.util.Optional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import spring.core.entity.Member;
import spring.core.repository.MemberRepository;

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
    public CommandLineRunner demo(MemberRepository repository) {
        return (args) -> {
            // save a few customers
            repository.save(new Member("Jack", "Bauer", "jack.bauer@gmail.com", "abcABC#@123"));
            repository.save(new Member("John", "Wick", "john.wick@gmail.com", "abcABCddaa#@123"));

            // fetch all customers
            System.out.println("Member found with findAll():");
            System.out.println("-------------------------------");
            for (Member member : repository.findAll()) {
                System.out.println(member.toString());
            }

            // fetch an individual customer by ID
            Member member = repository.findById(1L);
            System.out.println("member found with findById(1L):");

            System.out.println("--------------------------------------------");
            repository.findByFirstname("Jack").forEach(bauer -> {
                System.out.println(bauer.toString());
            });
        };
    }

}
