package com.example.furniture.sendmail;

import java.io.File;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
//Class
//Implementing EmailService interface
public class EmailServiceImpl {

 @Autowired
 private JavaMailSender javaMailSender;

 @Value("${spring.mail.username}") 
 private String sender;

 // Method 1
 // To send a simple email
 public String sendSimpleMail(String toEmail,String body, String subject)
 {

     // Try block to check for exceptions
     try {

         // Creating a simple mail message
         SimpleMailMessage mailMessage
             = new SimpleMailMessage();

         // Setting up necessary details
         mailMessage.setFrom(sender);
         mailMessage.setTo(toEmail);
         mailMessage.setText(body);
         mailMessage.setSubject(subject);

         // Sending the mail
         javaMailSender.send(mailMessage);
         return "Mail Sent Successfully...";
     }

     // Catch block to handle the exceptions
     catch (Exception e) {
         return "Error while Sending Mail";
     }

 }
}
