package dev.raj.industrylevelproject.Services;

import com.fasterxml.jackson.annotation.OptBoolean;
import dev.raj.industrylevelproject.Exceptions.NotFoundException;
import dev.raj.industrylevelproject.Models.Product;
import dev.raj.industrylevelproject.Repositories.ProductDBRepository;
import dev.raj.industrylevelproject.Services.FakeStoreServices.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class ProductDBImpleTest {
    @Autowired
    ProductService productService;

    @MockBean
    ProductDBRepository productDBRepository;

    @Test
    void TestProductInDBServiceReturnProduct() throws NotFoundException {
        when(productDBRepository.findProductById(any())).thenReturn(null);
       // Optional<Product> products = productService.getProductById(1L);
       assertThrows(NotFoundException.class,()->{
           productService.getProductById(1L);
       });
    }
    @Test
    void testAsserArrayEquals(){
         int[] ar1 = {1,2,4};
         int[] ar2 = {1,2,4};
            assertArrayEquals(ar2,ar1);
    }
}