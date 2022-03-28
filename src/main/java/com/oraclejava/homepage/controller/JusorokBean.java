package com.oraclejava.homepage.controller;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class JusorokBean implements Serializable {
    
    @NotNull @Min(0) @Max(99999)
    private Integer num;
    @NotBlank
    private String name;
    @NotBlank @Email
    private String mail;
}
