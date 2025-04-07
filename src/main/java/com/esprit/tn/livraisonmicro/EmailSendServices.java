package com.esprit.tn.livraisonmicro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSendServices {
    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail(String to,String subject,String text){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("saif.meddeb.52@gmail.com");
        message.setTo(to);
        message.setText(text);
        mailSender.send(message);
    }
}
