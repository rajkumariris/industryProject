package dev.raj.industrylevelproject.InheritanceExamples.MappedSuperClass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "ms_Instructor")
public class Instructor  extends User {
    private boolean isInstructor;
}
