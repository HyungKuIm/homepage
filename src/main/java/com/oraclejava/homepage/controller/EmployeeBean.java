package com.oraclejava.homepage.controller;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class EmployeeBean {
    
    @NotBlank(message = "사원 이름은 필수입력입니다.")
    @Size(min = 2, max = 30, message = "사원 이름은 2자이상 30자 이내로 입력해 주십시오")
    private String name;
    
    private MultipartFile file;
    
    private String gender;
    
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate birthday;
}
