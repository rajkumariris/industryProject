package dev.raj.industrylevelproject.DTOs;


import dev.raj.industrylevelproject.Models.SessionStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ValidateResponseDto {

    private UserDto userDto;
    private SessionStatus status;
}
