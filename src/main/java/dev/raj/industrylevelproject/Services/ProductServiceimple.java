package dev.raj.industrylevelproject.Services;

import dev.raj.industrylevelproject.Clients.FakeStoreClient;
import dev.raj.industrylevelproject.Clients.FakeStoreproductDto;
import dev.raj.industrylevelproject.DTOs.productDto;
import dev.raj.industrylevelproject.Models.Category;
import dev.raj.industrylevelproject.Models.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceimple implements ProductService{

    RestTemplateBuilder restTemplateBuilder;
    FakeStoreClient fakeStoreClient;
    public ProductServiceimple(RestTemplateBuilder restTemplateBuilder, FakeStoreClient fakeStoreClient) {
        this.restTemplateBuilder = restTemplateBuilder;
        this.fakeStoreClient = fakeStoreClient;
    }


    //convertFakeStoreProductDtoToProduct() is not defined in the snippet
    public Product convertFakeStoreProductDtoToProduct(FakeStoreproductDto productDto1){
        Product product = new Product();
        product.setTitle(productDto1.getTitle());
        product.setPrice(productDto1.getPrice());
        Category category = new Category();
        category.setName(productDto1.getCategory());
        product.setCategory(category);
        return  product;
    }


    public <T> ResponseEntity<T> requestForEntity(String url, HttpMethod httpMethod, @Nullable Object request, Class<T> responseType, Object... uriVariables) throws RestClientException {
        RestTemplate restTemplate = restTemplateBuilder.requestFactory(HttpComponentsClientHttpRequestFactory.class).build();
        //requestFactory() is used to set the request factory to use for obtaining client-side HTTP connections
        // used to get patch reqest patch directly dosnt suppot so we use thrid party client to do patch request



        RequestCallback requestCallback = restTemplate.httpEntityCallback(request, responseType);
        ResponseExtractor<ResponseEntity<T>> responseExtractor = restTemplate.responseEntityExtractor(responseType);
        return restTemplate.execute(url, httpMethod, requestCallback, responseExtractor, uriVariables);
    }
    @Override
    public List<Product> getAllProducts() {

       List<FakeStoreproductDto> fakeStoreproductDtos=  fakeStoreClient.getAllProducts();
        //converting productDto to product
        List<Product> products = new ArrayList<>();
        // for each loop to iterate through the productDtos
        for (FakeStoreproductDto productDto1 : fakeStoreproductDtos) {
            products.add(convertFakeStoreProductDtoToProduct(productDto1));
        }
        System.out.println(products);
        return products;
    }

    @Override
    public Optional<Product> getProductById(Long id) {
        RestTemplate restTemplate = restTemplateBuilder.build();//build() is used to build the object of RestTemplate
        ResponseEntity<FakeStoreproductDto> response =  restTemplate.getForEntity("https://fakestoreapi.com/products/{id}", FakeStoreproductDto.class,id);

        // responseEntity is for getting header, body, status code, as response


        if(response.getStatusCode().is1xxInformational()){
            //status code checking with responseentity response
        };

        //converting productDto to product
        FakeStoreproductDto productDto = response.getBody();

        if(productDto==null){ //Optional is used to avoid null pointer exception
            return Optional.empty(); // Optional.empty() is used to return the value
        }
       return Optional.of(convertFakeStoreProductDtoToProduct(productDto)); // Optinal.of() is used to return the value
    }

    @Override
    public Product addProduct(productDto product){
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreproductDto> response = restTemplate.postForEntity("https://fakestoreapi.com/products", product, FakeStoreproductDto.class);
        FakeStoreproductDto productDto = response.getBody();
        return convertFakeStoreProductDtoToProduct(productDto);
    }

    @Override
    public ResponseEntity<FakeStoreproductDto> updateProduct(Long productId,
                                 Product product) {

        FakeStoreproductDto productDto = new FakeStoreproductDto();
        productDto.setTitle(product.getTitle());
        productDto.setPrice(product.getPrice());
        productDto.setDescription(product.getDescription());
        productDto.setCategory(product.getCategory().getName());

       ResponseEntity<FakeStoreproductDto> fakeStoreproductDtoResponseEntity =
               requestForEntity("https://fakestoreapi.com/products/{id}", HttpMethod.PATCH, productDto, FakeStoreproductDto.class, productId);
       return  fakeStoreproductDtoResponseEntity;
    }

    public Product replaceProduct(Long productId, productDto productDto) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreproductDto> response =  requestForEntity("https://fakestoreapi.com/products/{id}", HttpMethod.PUT, productDto, FakeStoreproductDto.class, productId);
        Product productdata =  convertFakeStoreProductDtoToProduct(response.getBody());
      return productdata;
    }

    @Override
    public void deleteProduct(int id) {

    }
}
