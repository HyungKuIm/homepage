package com.oraclejava.homepage.controller;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class LoginBean {
    
    @NotBlank
    private String loginId;

    @NotBlank
    private String password;
}
