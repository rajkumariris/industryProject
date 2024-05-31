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

    FakeStoreClient fakeStoreClient;
    public ProductServiceimple(FakeStoreClient fakeStoreClient) {

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
        ResponseEntity<FakeStoreproductDto> fakestorentity = fakeStoreClient.getProductById(id);
        // responseEntity is for getting header, body, status code, as response
        if(fakestorentity.getStatusCode().is1xxInformational()){
            //status code checking with responseentity response
        };
        FakeStoreproductDto productDto = fakestorentity.getBody();
        if(productDto==null){ //Optional is used to avoid null pointer exception
            return Optional.empty(); // Optional.empty() is used to return the value
        }
       return Optional.of(convertFakeStoreProductDtoToProduct(productDto)); // Optinal.of() is used to return the value
    }

    @Override
    public Product addProduct(Product product){
        ResponseEntity<FakeStoreproductDto> response = fakeStoreClient.addProduct(product);
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
                fakeStoreClient.updateProduct(productId, productDto);
       return  fakeStoreproductDtoResponseEntity;
    }

    public Product replaceProduct(Long productId, productDto productDto) {
        Product product = new Product();
        ResponseEntity<FakeStoreproductDto> fakestoreproduct = fakeStoreClient.replaceProduct(productId, productDto);
        Product productdata =  convertFakeStoreProductDtoToProduct(fakestoreproduct.getBody());
      return productdata;
    }

    @Override
    public Product deleteProduct(Long id) {
       ResponseEntity<FakeStoreproductDto> response =  fakeStoreClient.deleteProduct(id);
       FakeStoreproductDto product =  response.getBody();
       return convertFakeStoreProductDtoToProduct(product);
    }
}
