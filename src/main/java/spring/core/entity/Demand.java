/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spring.core.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

/**
 *
 * @author robin
 */

@Entity
@Table(uniqueConstraints = {
    @UniqueConstraint(columnNames = {"code"})})
public class Demand implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String code;
    
    @NotNull
    private Date creationDate;
    
    @NotNull
    private Date treatmentDate;
    
    @NotNull
    private String Description;
    
    @NotNull
    private int criticality;
    
    @NotNull
    private String title;
    
    @NotNull
    private int priority;
    
    @NotNull
    private int type;
    
    @NotNull
    private String localisation;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getTreatmentDate() {
        return treatmentDate;
    }

    public void setTreatmentDate(Date treatmentDate) {
        this.treatmentDate = treatmentDate;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public int getCriticality() {
        return criticality;
    }

    public void setCriticality(int criticality) {
        this.criticality = criticality;
    }
    
    
    
}
