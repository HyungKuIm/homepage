package com.oraclejava.homepage.controller;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class JusorokBean implements Serializable {
    
    @NotNull
    private Integer num;
    @NotBlank
    private String name;
    @Email
    private String mail;
}
