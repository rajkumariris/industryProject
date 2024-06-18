package dev.raj.industrylevelproject.Clients;

import dev.raj.industrylevelproject.DTOs.FakeStoreCategoryDto;
import dev.raj.industrylevelproject.DTOs.productDto;
import dev.raj.industrylevelproject.Models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Component
public class FakeStoreClient {

    private  RestTemplateBuilder restTemplateBuilder;
    @Autowired
    private  RedisTemplate redisTemplate;

    public FakeStoreClient(RestTemplateBuilder restTemplateBuilder, RedisTemplate redisTemplate) {
        this.restTemplateBuilder = restTemplateBuilder;
        this.redisTemplate = redisTemplate;
    }


    public <T> ResponseEntity<T> requestForEntity(String url, HttpMethod httpMethod, @Nullable Object request, Class<T> responseType, Object... uriVariables) throws RestClientException {
        RestTemplate restTemplate = restTemplateBuilder.requestFactory(HttpComponentsClientHttpRequestFactory.class).build();
        //requestFactory() is used to set the request factory to use for obtaining client-side HTTP connections
        // used to get patch reqest patch directly dosnt suppot so we use thrid party client to do patch request
        RequestCallback requestCallback = restTemplate.httpEntityCallback(request, responseType);
        ResponseExtractor<ResponseEntity<T>> responseExtractor = restTemplate.responseEntityExtractor(responseType);
        return restTemplate.execute(url, httpMethod, requestCallback, responseExtractor, uriVariables);
    }

    public List<FakeStoreproductDto> getAllProducts(){
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreproductDto[]> productDto = restTemplate.getForEntity("https://fakestoreapi.com/products", FakeStoreproductDto[].class);
       return Arrays.asList(productDto.getBody());

    }

    // this map is out local cache we created ourself but redis is softwware
    // which helps to create cache for different servers
    // large cache is created by redis
    // internally it also storees data in different tables like products, categories etc
    Map<Long, FakeStoreproductDto> cachedSingleProduct = new HashMap<>();
    public ResponseEntity<FakeStoreproductDto> getProductById(Long id) {
        System.out.println("product cleint rest");
       FakeStoreproductDto fakeStoreproductDto =  (FakeStoreproductDto) redisTemplate.opsForHash().get(id, "PRODUCTS");
        if(fakeStoreproductDto!=null){
            return ResponseEntity.ok(fakeStoreproductDto);
        }

        RestTemplate restTemplate = restTemplateBuilder.build();//build() is used to build the object of RestTemplate
        ResponseEntity<FakeStoreproductDto> response = restTemplate.getForEntity("https://fakestoreapi.com/products/{id}", FakeStoreproductDto.class, id);
        redisTemplate.opsForHash().put(id, "PRODUCTS",response.getBody());
        //in put() method first->id, second -> tablename(can be anything), three->data
        //cachedSingleProduct.put(id, response.getBody());
        return response;
    }
    public ResponseEntity<FakeStoreproductDto> addProduct(Product product){
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreproductDto> response = restTemplate.postForEntity("https://fakestoreapi.com/products", product, FakeStoreproductDto.class);
        return response;
    }
    public ResponseEntity<FakeStoreproductDto> updateProduct(Long productId, FakeStoreproductDto product){
        ResponseEntity<FakeStoreproductDto> fakeStoreproductDtoResponseEntity =
                requestForEntity("https://fakestoreapi.com/products/{id}", HttpMethod.PATCH, product, FakeStoreproductDto.class, productId);

        return null;
    }
    public ResponseEntity<FakeStoreproductDto> deleteProduct(Long id){
      ResponseEntity<FakeStoreproductDto> response =   requestForEntity("https://fakestoreapi.com/products/{id}", HttpMethod.DELETE, null, FakeStoreproductDto.class, id);
      return response;
    }

    public ResponseEntity<FakeStoreproductDto> replaceProduct(Long productId, productDto productDto){
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreproductDto> response =  requestForEntity("https://fakestoreapi.com/products/{id}", HttpMethod.PUT, productDto, FakeStoreproductDto.class, productId);
        return response;
    }

    public List<String> getallCategories(){
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<String[]> categoryDto = restTemplate.getForEntity("https://fakestoreapi.com/products/categories", String[].class);
        System.out.println("hellow");
        return Arrays.asList(categoryDto.getBody());
     }

     public List<FakeStoreproductDto> getProductsInCategory(String category){
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreproductDto[]> productDto = restTemplate.getForEntity("https://fakestoreapi.com/products/category/{category}", FakeStoreproductDto[].class, category);
        return Arrays.asList(productDto.getBody());
     }
}
