package com.oraclejava.homepage.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class Member {
    @Id
    @NotNull
    private Long id;
    private String loginId;
    private String name;
    private String password;

}
