package spring.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.core.entity.User;
import spring.core.service.EmailService;
import spring.utils.Emailconfig;

import java.text.ParseException;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private Emailconfig emailconfig;

    @Override
    public void EnvoieMotdePasse(User user, String motdepasse) throws ParseException {
        String message = "Bonjour voici votre mot de passe de connection pour le service desk : "+motdepasse;
        String email = user.getEmail();
        String sujet = "Mot de passe Service Desk";
        emailconfig.sendnotification(user.getEmail(), message ,sujet);
    }
}
