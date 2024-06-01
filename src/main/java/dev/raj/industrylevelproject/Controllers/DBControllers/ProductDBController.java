package dev.raj.industrylevelproject.Controllers.DBControllers;


import dev.raj.industrylevelproject.Clients.FakeStoreproductDto;
import dev.raj.industrylevelproject.Controllers.DBControllers.ExceptionAdvisors.ProductNotFoundException;
import dev.raj.industrylevelproject.DTOs.productDto;
import dev.raj.industrylevelproject.Models.Category;
import dev.raj.industrylevelproject.Models.Product;
import dev.raj.industrylevelproject.Services.FakeStoreServices.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/items")
public class ProductDBController {


    ProductService productService;
    public ProductDBController(ProductService productService){
        this.productService = productService;
    }
    @GetMapping("/dbproducts/{id}")
    public String getSingledbproduct(@PathVariable("id") Long id) throws ProductNotFoundException{

       Optional<Product> product =  productService.getProductById(id);
      if(product.isEmpty()) {
            throw new ProductNotFoundException();
      }
       return product.toString();
    }

    @PostMapping()
    public String adddbProduct(@RequestBody productDto product){

        Product productsave = new Product();
        productsave.setTitle(product.getTitle());
        productsave.setPrice(product.getPrice());
        productsave.setDescription(product.getDescription());
        Category category = new Category();
        category.setName(product.getCategory());
        productsave.setCategory(category);
        productsave.setImage(product.getImage());

       Product product1 = productService.addProduct(productsave);
         return product1.toString().toString();

    }

    @DeleteMapping("/dbproducts/{id}")
    public String deleteProduct(@PathVariable("id") Long id) throws ProductNotFoundException{
          productService.deleteProduct(id);
//        if(product == null){
//            throw new ProductNotFoundException();
//        }
        return "Product Deleted";
    }

    @PutMapping("/dbproducts/{id}")
    public FakeStoreproductDto updateProduct(@PathVariable("id") Long id,@RequestBody productDto productDto) throws ProductNotFoundException{


        Product product = new Product();
        product.setTitle(productDto.getTitle());
        product.setDescription(productDto.getDescription());
        Category category = new Category();
        category.setName(productDto.getCategory());
        product.setCategory(category);
         FakeStoreproductDto fakeStoreproductDto = productService.updateProduct(id, product).getBody();
        return fakeStoreproductDto;
    }

}
