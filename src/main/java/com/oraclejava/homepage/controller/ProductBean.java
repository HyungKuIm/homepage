package com.oraclejava.homepage.controller;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class ProductBean implements Serializable {
    
    @NotBlank(message = "제품명은 필수입력입니다.")
    @Size(min = 2, max = 30, message = "제품명은 2자이상 30자 이내로 입력해 주십시오")
    private String name;

    @NotBlank(message = "제품 설명은 필수입력입니다.")
    private String description;

    private Double price;

    private MultipartFile file;
    


}
