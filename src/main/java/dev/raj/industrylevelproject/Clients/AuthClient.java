package dev.raj.industrylevelproject.Clients;

import dev.raj.industrylevelproject.DTOs.ValidateResponseDto;
import dev.raj.industrylevelproject.DTOs.ValidateTokenRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
@Component
public class AuthClient {

    RestTemplate restTemplate;

    public AuthClient(){
        this.restTemplate = new RestTemplate();
    }

    public ResponseEntity<ValidateResponseDto> validate(String token, Long id){

        ValidateTokenRequestDto validateTokenRequestDto = new ValidateTokenRequestDto();
        validateTokenRequestDto.setToken(token);
        validateTokenRequestDto.setUserId(id);
        System.out.println("Token: "+token);

        ResponseEntity<ValidateResponseDto> response=  restTemplate.postForEntity("http://localhost:9000/auth/validate",
                 validateTokenRequestDto,
                ValidateResponseDto.class);
        return response;
    }
}
