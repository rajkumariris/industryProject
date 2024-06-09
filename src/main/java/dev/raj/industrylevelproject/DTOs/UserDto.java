package dev.raj.industrylevelproject.DTOs;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
public class UserDto {
   private String email;
   private Set<Role> roles = new HashSet<>();

   public static UserDto from(User user){
       UserDto userDto = new UserDto();
       userDto.setEmail(user.getEmail());
       return userDto;
   }
}
