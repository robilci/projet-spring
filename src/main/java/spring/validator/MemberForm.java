/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spring.validator;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.SafeHtml;
import org.hibernate.validator.constraints.SafeHtml.WhiteListType;

/**
 *
 * @author robin
 */
public class MemberForm {

    @NotNull(message="")
    @Size(min = 2, max = 30, message = "Le prénom doit contenir entre 2 et 30 caractères")
    private String firstname;
    
    @NotNull
    @Size(min = 2, max = 30, message = "Le nom doit contenir entre 2 et 30 caractères")
    private String lastname;
    
    @NotNull
    @Pattern(regexp="^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", flags = Pattern.Flag.CASE_INSENSITIVE, message = "Email invalide")
    private String email;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    @Override
    public String toString() {
        return "Membre : " + firstname + " " + lastname + " - " + email;
    }

}
