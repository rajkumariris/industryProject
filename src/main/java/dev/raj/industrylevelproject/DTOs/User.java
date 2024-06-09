package dev.raj.industrylevelproject.DTOs;


import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class User{

    private String email;
    private String password;
    private Set<Role> roles = new HashSet<>();

}
