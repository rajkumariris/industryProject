package dev.raj.industrylevelproject.Services;

import dev.raj.industrylevelproject.Clients.FakeStoreproductDto;
import dev.raj.industrylevelproject.DTOs.productDto;
import dev.raj.industrylevelproject.Models.Product;
import dev.raj.industrylevelproject.Repositories.ProductDBRepository;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public class ProductDBImple implements ProductService{

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
        return Optional.empty();
    }

    @Override
    public Product addProduct(Product product) {
       Product product1=  productDBRepository.save(product);
     return  product1;
    }

    @Override
    public ResponseEntity<FakeStoreproductDto> updateProduct(Long productId, Product product) {
        return null;
    }

    @Override
    public Product deleteProduct(Long id) {
        return null;
    }

    @Override
    public Product replaceProduct(Long productId, productDto productDto) {
        return null;
    }
}
