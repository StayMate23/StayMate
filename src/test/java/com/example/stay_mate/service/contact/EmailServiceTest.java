package com.example.stay_mate.service.contact;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EmailServiceTest {

    @Mock
    private JavaMailSender javaMailSender;

    @InjectMocks
    private EmailService emailService;

    @Test
    void sendEmail_Success() {
        // Given
        String emailAddress = "test@example.com";
        String emailSubject = "Test Subject";
        String emailText = "<html><body>This is a test email</body></html>";

        // When
        emailService.sendEmail(emailAddress, emailSubject, emailText);

        // Then
        verify(javaMailSender, times(1)).send(any(MimeMessagePreparator.class));
    }

    @Test
    void sendEmail_Failure() {
        // Given
        String emailAddress = "test@example.com";
        String emailSubject = "Test Subject";
        String emailText = "<html><body>This is a test email</body></html>";

        // Mocking JavaMailSender to throw an exception when send is called
        doThrow(new RuntimeException("Simulated email sending failure")).when(javaMailSender).send(any(MimeMessagePreparator.class));

        // When
        emailService.sendEmail(emailAddress, emailSubject, emailText);

        // Then
        verify(emailService.getLog(), times(1));
    }
}

