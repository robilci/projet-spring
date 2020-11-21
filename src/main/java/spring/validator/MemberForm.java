/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spring.validator;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 *
 * @author robin
 */
public class MemberForm {

    @NotNull
    @Size(min = 2, max = 30)
    private String firstName;
    
    @NotNull
    @Size(min = 2, max = 30)
    private String lastName;
    
    @NotNull
    @Size(min = 2, max = 30)
    private String email;
    
        
    /*      *********  PASSWORD  ************
        (?=.*[0-9])         au moins un chiffre
        (?=.*[a-z])         au moins une minuscule
        (?=.*[A-Z])         au moins une majuscule
        (?=.*[@#$%^&+=])    au moins un caractère spécial
        (?=\\S+$)           aucun espace autorisé
        .{8,}               au moins 8 caractères
    */
    
    @NotNull
    @Size(min = 8, max = 30)
    @Pattern(regexp="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$")
    private String password;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    @Override
    public String toString() {
        return "Membre : " + firstName + " " + lastName + " - " + email;
    }

}
