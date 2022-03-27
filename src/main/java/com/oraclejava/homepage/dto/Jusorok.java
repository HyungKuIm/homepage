package com.oraclejava.homepage.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
