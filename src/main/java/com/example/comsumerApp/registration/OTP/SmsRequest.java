package com.example.comsumerApp.registration.OTP;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public class SmsRequest {

    public  String otp(int random) {
        random = 3;
        return otp(random);
    }

    @NotBlank
    private final String phoneNumber; // destination

    @NotBlank
    private String message;

    public SmsRequest( @JsonProperty("phoneNumber") String phoneNumber,
                      @JsonProperty("message") String message) {
        this.phoneNumber = phoneNumber;
        this.message = message;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getMessage() {

        message = "Your verification code is:"  ;
        return message;
    }

    @Override
    public String toString() {
        return "SmsRequest{" +
                "phoneNumber= ..." + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
