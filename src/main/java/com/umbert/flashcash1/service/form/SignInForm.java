package com.umbert.flashcash1.service.form;


import lombok.Data;

@Data
public class SignInForm {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String confirmPassword;

}
