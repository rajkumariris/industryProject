package dev.raj.industrylevelproject.Controllers.DBControllers;


import dev.raj.industrylevelproject.Clients.FakeStoreproductDto;
import dev.raj.industrylevelproject.DTOs.ErrorHanlderdto;
import dev.raj.industrylevelproject.DTOs.productDto;
import dev.raj.industrylevelproject.Exceptions.NotFoundException;
import dev.raj.industrylevelproject.Exceptions.ProductNotFoundException;
import dev.raj.industrylevelproject.Models.Category;
import dev.raj.industrylevelproject.Models.Product;
import dev.raj.industrylevelproject.Services.FakeStoreServices.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/items")
public class ProductDBController {
  //@Qualifier says i have given name to each service implementation one is fakestore antoehr one is
    //db so use whichever service u want by annotating @Qualifier to productservice or else it get
    //confused which service to use

    ProductService productService;
    public ProductDBController(@Qualifier("ProductDBImple") ProductService productService){
        this.productService = productService;
    }
    @GetMapping("/dbproducts/{id}")
    public Optional<Product>getSingledbproduct(@PathVariable("id") Long id) throws NotFoundException {

       Optional<Product> product =  productService.getProductById(id);
      if(product.isEmpty()) {
            throw new NotFoundException("Product in db not found");
      }
       return product;
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
    public String deleteProduct(@PathVariable("id") Long id) throws NotFoundException{
          productService.deleteProduct(id);
//        if(product == null){
//            throw new ProductNotFoundException();
//        }
        return "Product Deleted";
    }

    @PutMapping("/dbproducts/{id}")
    public FakeStoreproductDto updateProduct(@PathVariable("id") Long id,@RequestBody productDto productDto) throws NotFoundException{
        Product product = new Product();
        product.setTitle(productDto.getTitle());
        product.setDescription(productDto.getDescription());
        Category category = new Category();
        category.setName(productDto.getCategory());
        product.setCategory(category);
         FakeStoreproductDto fakeStoreproductDto = productService.updateProduct(id, product).getBody();
        return fakeStoreproductDto;
    }
        @ExceptionHandler(ProductNotFoundException.class) // if any where notFoundException is thrown  in this controller then this method will be called
        public ResponseEntity<ErrorHanlderdto> ErrorHandler(){
        ErrorHanlderdto errorHanlderdto = new ErrorHanlderdto();
        errorHanlderdto.setErrorMessage("Product not found");
        return new ResponseEntity(errorHanlderdto, HttpStatus.NOT_FOUND);
    }

}
