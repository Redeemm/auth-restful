package com.example.comsumerApp.registration;

import com.example.comsumerApp.exception.ApiNotFoundException;
import com.example.comsumerApp.exception.ApiRequestException;
import com.example.comsumerApp.modeller.user.User;
import com.example.comsumerApp.modeller.user.UserRole;
import com.example.comsumerApp.modeller.user.UserService;
import com.example.comsumerApp.registration.email.EmailSender;
import com.example.comsumerApp.registration.token.ConfirmationToken;
import com.example.comsumerApp.registration.token.ConfirmationTokenService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final UserService userService;
    private final EmailValidator emailValidator;
    private final ConfirmationTokenService confirmationTokenService;
    private final EmailSender emailSender;

    public String register(RegistrationRequest request) {
        boolean isValidEmail = emailValidator.test(request.getEmail());
        if (!isValidEmail) {
            throw new ApiRequestException("Email not valid");
        }
        String token = userService.signUpUser(
                new User(
                        request.getFirstName(),
                        request.getLastName(),
                        request.getEmail(),
                        request.getPassword(),
                        UserRole.USER
                )
        );

        String link = "http://localhost:8080/api/v1/registration/confirm?token=" + token;
        emailSender.send(
                request.getEmail(),
                buildEmail(request.getFirstName(), link));

        return token;
    }

    @Transactional
    public String confirmToken(String token) {
        ConfirmationToken confirmationToken = confirmationTokenService
                .getToken(token)
                .orElseThrow(() ->
                        new ApiNotFoundException("Token not found"));

        if (confirmationToken.getConfirmedAt() != null) {
            throw new ApiRequestException("Email already confirmed");
        }

        LocalDateTime expiredAt = confirmationToken.getExpiresAt();

        if (expiredAt.isBefore(LocalDateTime.now())) {
            throw new ApiRequestException("Token expired");
        }

        confirmationTokenService.setConfirmedAt(token);
        userService.enableUser(
                confirmationToken.getUser().getEmail());
        return "User successfully confirmed";
    }

    private String buildEmail(String name, String link) {
        return "Email template with link to activation";
    }
}
