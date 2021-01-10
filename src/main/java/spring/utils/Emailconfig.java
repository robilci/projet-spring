package spring.utils;

import org.springframework.stereotype.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
public class Emailconfig {

    private JavaMailSender javaMailSender;

    @Autowired
    public Emailconfig(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }
 /*
    @Autowired
    public Emailconfig(JavaMailSender javaMailSender) {
        super();
        this.javaMailSender = javaMailSender;
    }
    */

    public void sendnotification(String destinateur,String message,String subjet )throws MailException {
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(destinateur);
        mail.setFrom("oumarkante301@gmail.com");
        mail.setSubject(subjet);
        mail.setText(message);
        javaMailSender.send(mail);
    }


    public void sendMessageWithAttachment(
            String to, String subject, String text, String pathToAttachment)throws MailException {
        // ...

        MimeMessage message = javaMailSender.createMimeMessage();

        MimeMessageHelper helper;
        try {
            helper = new MimeMessageHelper(message, true);
            helper.setTo("oumarkante30@gmail.com");
            helper.setSubject("test email with attachement");
            helper.setText(" ca march variament c'est super");
            FileSystemResource file
                    = new FileSystemResource(new File("C:\\Users\\poo\\Desktop 2\\ad\\TP1_AD.pdf"));
            helper.addAttachment("TP1_AD.pdf", file);
        } catch (MessagingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        javaMailSender.send(message);
        // ...
    }



}
