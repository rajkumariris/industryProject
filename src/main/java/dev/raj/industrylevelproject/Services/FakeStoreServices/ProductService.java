package dev.raj.industrylevelproject.Services.FakeStoreServices;

import dev.raj.industrylevelproject.Clients.FakeStoreproductDto;
import dev.raj.industrylevelproject.Controllers.DBControllers.ExceptionAdvisors.ProductNotFoundException;
import dev.raj.industrylevelproject.DTOs.productDto;
import dev.raj.industrylevelproject.Models.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    public List<Product> getAllProducts();
    public Optional<Product> getProductById(Long id);
    public Product addProduct(Product product);
    public ResponseEntity<FakeStoreproductDto> updateProduct(Long productId, Product product) throws ProductNotFoundException;
    public void deleteProduct(Long id);

    public Product replaceProduct(Long productId, productDto productDto);

}
