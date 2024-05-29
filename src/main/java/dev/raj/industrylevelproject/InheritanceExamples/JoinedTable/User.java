package dev.raj.industrylevelproject.InheritanceExamples.JoinedTable;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "jt_user")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;
}


// creates seperate table for each and each table has parent class id(user id)
// in other class except parent class we give @PrimaryKeyJoinColumn(name = "user_id") to tell that this is the parent class id
// create column for it