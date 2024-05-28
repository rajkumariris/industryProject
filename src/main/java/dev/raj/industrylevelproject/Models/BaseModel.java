package dev.raj.industrylevelproject.Models;

import lombok.*;

import java.util.Date;

@Getter // creates getters for all fields in the class.
@Setter
@AllArgsConstructor // creates a constructor with all the fields of the class as arguments.
@NoArgsConstructor // creates a constructor with no arguments.
@Builder // creates a builder so that you can build the object of the class.
public class BaseModel {
    private Long id;
    private Date CreatedAt;
    private Date UpdatedAt;
    private boolean isDeleted;
}
