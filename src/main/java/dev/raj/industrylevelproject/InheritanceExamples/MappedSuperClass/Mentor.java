package dev.raj.industrylevelproject.InheritanceExamples.MappedSuperClass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "ms_Mentor")
public class Mentor extends User {
    private int NoOfSessions;
    private int NoOfMentees;
}
