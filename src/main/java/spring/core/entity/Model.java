/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spring.core.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
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
public class Model implements Serializable {

    @Id
    private Long id;
    
    @NotNull
    @Size(min = 2, max = 28)
    private String title;
    
    @NotNull
    private int priority;
    
    @NotNull
    private int type;
    
    @NotNull
    @Size(min = 2, max = 46)
    private String localisation;

    public Model(String title, int priority, int type, String localisation) {
        this.title = title;
        this.priority = priority;
        this.type = type;
        this.localisation = localisation;
    }
  
    public Model(){}
    
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

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }
      
}
