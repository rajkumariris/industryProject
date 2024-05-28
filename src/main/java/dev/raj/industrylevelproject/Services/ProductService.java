package dev.raj.industrylevelproject.Services;

import dev.raj.industrylevelproject.Clients.FakeStoreproductDto;
import dev.raj.industrylevelproject.DTOs.productDto;
import dev.raj.industrylevelproject.Models.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    public List<Product> getAllProducts();
    public Optional<Product> getProductById(Long id);
    public Product addProduct(productDto product);
    public ResponseEntity<FakeStoreproductDto> updateProduct(Long productId, Product product);
    public Product deleteProduct(Long id);

    public Product replaceProduct(Long productId, productDto productDto);

}
