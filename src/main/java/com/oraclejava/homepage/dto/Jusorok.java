package com.oraclejava.homepage.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Jusorok implements Serializable {
    @Id
    @NotNull
    private int num;
    private String name;
    private String mail;
}
