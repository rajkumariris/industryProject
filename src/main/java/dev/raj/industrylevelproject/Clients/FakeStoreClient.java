package dev.raj.industrylevelproject.Clients;

import dev.raj.industrylevelproject.DTOs.productDto;
import dev.raj.industrylevelproject.Models.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class FakeStoreClient {

    RestTemplateBuilder restTemplateBuilder;

    public FakeStoreClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }
    public List<FakeStoreproductDto> getAllProducts(){
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreproductDto[]> productDto = restTemplate.getForEntity("https://fakestoreapi.com/products", FakeStoreproductDto[].class);
       return Arrays.asList(productDto.getBody());

    }
//    public Optional<FakeStoreproductDto> getProductById(Long id){
//        RestTemplate restTemplate = restTemplateBuilder.build();//build() is used to build the object of RestTemplate
//        ResponseEntity<FakeStoreproductDto> response =  restTemplate.getForEntity("https://fakestoreapi.com/products/{id}", FakeStoreproductDto.class,id);
//        return Optional.ofNullable(response.getBody());
//    }
    public Product addProduct(productDto product){
        return null;

    }
    public ResponseEntity<FakeStoreproductDto> updateProduct(Long productId, Product product){
        return null;
    }
    public void deleteProduct(int id){

    }

    public Product replaceProduct(Long productId, productDto productDto){
        return null;
    }

}
