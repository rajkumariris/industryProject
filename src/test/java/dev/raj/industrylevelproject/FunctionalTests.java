package dev.raj.industrylevelproject;

import dev.raj.industrylevelproject.Controllers.DBControllers.ProductDBController;
import dev.raj.industrylevelproject.Controllers.FakeStoreControllers.ProductController;
import dev.raj.industrylevelproject.Repositories.ProductDBRepository;
import dev.raj.industrylevelproject.Services.FakeStoreServices.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

//@WebMvcTest(ProductDBController.class)
public class FunctionalTests {


    //@Autowired
    private MockMvc mockMvc;
    //

   // @MockBean
    private ProductService productService;

    //@MockBean
    private ProductController productController;
   // @MockBean
    private ProductDBRepository productDBRepository;
    //@Test
    void testAllproduct() throws Exception {
//        mockMvc.perform(get("/products"))
//                .andExpect(status().is(200))
//                .andExpect(header().exists("autorizaton"))
//                .andExpect(content().string("{}"));
//
   }
}
