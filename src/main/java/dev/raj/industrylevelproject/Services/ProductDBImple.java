package dev.raj.industrylevelproject.Services;

import dev.raj.industrylevelproject.Clients.FakeStoreproductDto;
import dev.raj.industrylevelproject.Controllers.DBControllers.ExceptionAdvisors.ProductNotFoundException;
import dev.raj.industrylevelproject.DTOs.productDto;
import dev.raj.industrylevelproject.Models.Product;
import dev.raj.industrylevelproject.Repositories.FakeStoreRepositories.ProductRepository;
import dev.raj.industrylevelproject.Repositories.ProductDBRepository;
import dev.raj.industrylevelproject.Services.FakeStoreServices.ProductService;
import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ProductDBImple implements ProductService {

    ProductDBRepository productDBRepository;


    public ProductDBImple(ProductDBRepository productDBRepository){
        this.productDBRepository = productDBRepository;

    }
    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public Optional<Product> getProductById(Long id) {
       Product product =  productDBRepository.findProductById(id);
       if(product == null){
              return Optional.empty();
       }
       return Optional.of(product);
    }

    @Override
    public Product addProduct(Product product) {
       Product product1=  productDBRepository.save(product);
     return  product1;
    }

    @Override
    public ResponseEntity<FakeStoreproductDto> updateProduct(Long ProductId,Product product) throws ProductNotFoundException {
       Product productfind = productDBRepository.findProductById(ProductId);
       if(productfind == null) {
           throw new ProductNotFoundException();
       }
        productfind.setTitle(product.getTitle());
        productfind.setPrice(product.getPrice());
        productfind.setDescription(product.getDescription());
        productfind.setImage(product.getImage());


      Product productup = productDBRepository.save(productfind);
     FakeStoreproductDto fakeStoreproductDto = new FakeStoreproductDto();
     fakeStoreproductDto.setPrice(productup.getPrice());
        fakeStoreproductDto.setTitle(productup.getTitle());
        fakeStoreproductDto.setCategory(productup.getCategory().getName());
        return ResponseEntity.ok(fakeStoreproductDto);
    }

    @Transactional
    @Override
    public void deleteProduct(Long id){
         productDBRepository.deleteProductById(id);

    }

    @Override
    public Product replaceProduct(Long productId, productDto productDto) {
        return null;
    }
}
