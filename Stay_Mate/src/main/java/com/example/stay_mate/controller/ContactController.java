package com.example.stay_mate.controller;

import com.example.stay_mate.model.EmailForm;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ContactController {


    private final JavaMailSender javaMailSender;

    public ContactController(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @GetMapping("/contact")
    public String showContactForm() {
        return "contact";
    }

    @PostMapping("/contact")
    public String sendEmail(EmailForm form) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("23StayMate23@gmail.com");
        message.setSubject(form.getSubject());
        message.setText("Name: " + form.getName() + "\nEmail: " + form.getEmail() + "\nMessage: " + form.getMessage());

        javaMailSender.send(message);

        return "message"; // Az elküldés után a felhasználót átirányítjuk egy sikeroldalra.
    }
}