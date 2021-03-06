/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spring.core.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author robin
 */
@Entity
@Table(uniqueConstraints = {
    @UniqueConstraint(columnNames = {"title"})})
public class ModelDemand implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @NotNull
    @Size(min = 2, max = 28)
    private String title;
    
    @NotNull
    private int priority;
    
    @NotNull
    private int type;
    
    @ManyToOne
    private Domain domain;
    
    @NotNull
    @Size(min = 2, max = 46)
    private String location;

    public ModelDemand(String title, int priority, int type, String location, Domain domain) {
        this.title = title;
        this.priority = priority;
        this.type = type;
        this.location = location;
        this.domain = domain;
    }
  
    public ModelDemand(){}
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Domain getDomain() {
        return domain;
    }

    public void setDomain(Domain domain) {
        this.domain = domain;
    }
        
}
