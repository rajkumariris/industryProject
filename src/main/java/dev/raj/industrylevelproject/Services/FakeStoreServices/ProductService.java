package dev.raj.industrylevelproject.Services.FakeStoreServices;

import dev.raj.industrylevelproject.Clients.FakeStoreproductDto;
//import dev.raj.industrylevelproject.Controllers.DBControllers.ProductNotFoundException;
import dev.raj.industrylevelproject.DTOs.productDto;
import dev.raj.industrylevelproject.Exceptions.NotFoundException;
import dev.raj.industrylevelproject.Models.Product;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    public List<Product> getAllProducts();
    public Optional<Product> getProductById(Long id) throws NotFoundException;
    public Product addProduct(Product product);
    public ResponseEntity<FakeStoreproductDto> updateProduct(Long productId, Product product) throws NotFoundException;
    public void deleteProduct(Long id);

    public Product replaceProduct(Long productId, productDto productDto);


    public Page<Product> searchProducts(String searchTerm, int NumberOfproduct, int offset);
}
