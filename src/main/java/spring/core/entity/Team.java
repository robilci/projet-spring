/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spring.core.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author robin
 */
@Entity
public class Team implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    
    @NotNull
    @Size(min = 2, max = 30, message = "Le nom du groupe doit contenir entre 2 et 30 caractères")
    String name;
    
    @OneToMany(mappedBy = "team")
    private List<Member> members;

    public Team() {
    }
    
    public Team(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public String toString(){
        return "Team : " + name;
    }
    
}
