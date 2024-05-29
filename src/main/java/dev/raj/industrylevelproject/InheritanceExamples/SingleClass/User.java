package dev.raj.industrylevelproject.InheritanceExamples.SingleClass;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "st_user")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn( // this colums is for usertype (1 for TA, 2 for Mentor, 3 for Instructor )
        name = "user_type", // column name is user_type and type is interger to reperest (mentor, ta, instructor)
        discriminatorType = DiscriminatorType.INTEGER) // create sepearte column for type(1 for TA, 2 for Mentor, 3 for Instructor ))
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String email;
    private String password;
}


// create all the colums in single table and every column type is also given (mentor, ta, instructor)