package com.mk.springpanzersapi.controllers.auth.classes;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;
import java.util.Random;

public class SecretCode {

    private static String getHostFromEmail(String email){
        String host = "";
        for (int i = email.length() - 1; i >= 0; --i) {
            if (email.charAt(i) != '@')
                host = email.charAt(i) + host;
            else break;
        }
        return host;
    }

    private static String generateCode(){
        Random rand = new Random();
        return Integer.toString(rand.nextInt(899999) + 100000);
    }

    public static String sendCode(String nickname, String email) {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        SimpleMailMessage message = new SimpleMailMessage();
        Properties props = mailSender.getJavaMailProperties();
        String code = generateCode();
        mailSender.setHost("smtp." + getHostFromEmail(email));
        mailSender.setPort(25);
        mailSender.setUsername("vmminigames@gmail.com");
        mailSender.setPassword("tfsseetwdoxikuof");
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");
        message.setTo(email);
        message.setSubject("Browser Tanks");
        message.setText("Hi " + nickname + ". Your secret code: " + code);
        mailSender.send(message);
        return code;
    }
}
