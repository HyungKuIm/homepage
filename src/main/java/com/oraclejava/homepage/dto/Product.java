package com.oraclejava.homepage.dto;

import java.time.LocalDateTime;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class Product {
    @Id
    @NotNull
    private Long id;
    
    private LocalDateTime createDate;
    
    private String description;
    
    @Lob
    @Basic(fetch = FetchType.LAZY)
    private byte[] image;
    
    private String name;
    
    private Double price;


}
