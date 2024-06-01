package dev.raj.industrylevelproject.InheritanceExamples.MappedSuperClass;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;
}
// it create 3 tables not user @mappedsuperclass helps to put parent attributes in all the chld class