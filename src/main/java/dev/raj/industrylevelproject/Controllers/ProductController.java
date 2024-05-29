package dev.raj.industrylevelproject.Controllers;

import dev.raj.industrylevelproject.Clients.FakeStoreproductDto;
import dev.raj.industrylevelproject.DTOs.ProductResponseDto;
import dev.raj.industrylevelproject.DTOs.productDto;
import dev.raj.industrylevelproject.Exceptions.NotFoundException;
import dev.raj.industrylevelproject.Models.Category;
import dev.raj.industrylevelproject.Models.Product;
import dev.raj.industrylevelproject.Services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//@Controller , @Service, @Repository are the stereotype annotations in spring which are used for auto-detection and dependency injection of spring beans or creating beans
//tells spring inside the class some http methods are there register that in your dispacher if
//particular call on that is coming serve that
@RestController //tells spring this is a controller class
@RequestMapping("/products") //@Requestmapping /products we need not to use every time in other methods /products as prefix
public class ProductController {

    ProductService productService; //creating object of ProductService class
    public ProductController(ProductService productService){
        this.productService = productService;
    }




    @GetMapping()//if the url is /products then this method will be called
    public List<Product> getAllProducts(){
        List<Product> products = productService.getAllProducts();
        return products;
    }

    @GetMapping("/{product_id}") //if the url is /products/{product_id} then this method will be called
    // here product_id is a variable getting it from the url
    //setting headers using map
    public ResponseEntity<ProductResponseDto> getSingleProduct(@PathVariable("product_id") Long Productid) throws  NotFoundException { // @PathVariable is used to get the value of the variable in the url
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("auth-token", "123456");
        // In the getSingleProduct method,
        // the NotFoundException is being thrown but not caught.
        // Therefore, it must be declared in the method signature.
        // This informs the callers of the method that they need to handle this exception
        Optional<Product> products = productService.getProductById(Productid);
        if(products.isEmpty()){
            throw new NotFoundException("product wrong");
        }
        //productsercice returning product model type but controller has to return dto only
        //so we are creating dto object and setting the product object in it and returning the dto object
        ResponseEntity<ProductResponseDto> response = new ResponseEntity(
                //productService.getProductById(Productid),
                products,
                headers,  // sending headers along with response
                HttpStatus.NOT_FOUND);
        //headers sending alog with responsenentity
        return response;
    }

    @PostMapping()
    public ResponseEntity<Product> addProduct(@RequestBody productDto product){ // productDto is a class which get data from url body parse it from
        //json to java object and store it in productDto object using jackson line by line
        //RequestBody is used to get the data from the body of the url
       Product product2=  productService.addProduct(product); //calling addProduct method of ProductService class and passing productDto object as argument
        ResponseEntity<Product> response = new ResponseEntity(product2, HttpStatus.CREATED);
        return response;
    }

    @PatchMapping("/{product_id}")
    public ResponseEntity<FakeStoreproductDto> updateProduct(@PathVariable("product_id") Long Productid, @RequestBody productDto productDto){
       Product product = new Product();
         product.setTitle(productDto.getTitle());
            product.setDescription(productDto.getDescription());
            product.setPrice(productDto.getPrice());
            Category category = new Category();
            category.setName(productDto.getCategory());
            product.setCategory(category);
            product.setTitle(productDto.getTitle());
            product.setImage(productDto.getImage());
       ResponseEntity<FakeStoreproductDto> updatedProduct =   productService.updateProduct(Productid, product);
        return updatedProduct;
    }


    @PutMapping("/{product_id}")
    public productDto replaceProduct(@PathVariable("product_id") Long productId, @RequestBody productDto productDto){
       Product product =  productService.replaceProduct(productId, productDto);
       productDto productDto1 = new productDto();
        productDto1.setTitle(product.getTitle());
        productDto1.setDescription(product.getDescription());
        productDto1.setPrice(product.getPrice());
        productDto1.setCategory(product.getCategory().getName());
        productDto1.setImage(product.getImage());

    return productDto1;

    }

    @DeleteMapping("/{product_id}")
    public productDto deleteproduct(@PathVariable("product_id") Long productId){
        Product product=   productService.deleteProduct(productId);
        productDto productDto = new productDto();
        productDto.setTitle(product.getTitle());
        productDto.setDescription(product.getDescription());
        productDto.setPrice(product.getPrice());
        productDto.setCategory(product.getCategory().getName());
        productDto.setImage(product.getImage());
        return productDto;
    }


/// ----------- this handler only for this controller but we are handling globally using @ControllerAdvice check ExceptionAdvisors.java ---------------
//1st way of exceptional handling

//    @ExceptionHandler(NotFoundException.class) // if any where notFoundException is thrown  in this controller then this method will be called
//    public ResponseEntity<ErrorHanlderdto> ErrorHandler(){
//        ErrorHanlderdto errorHanlderdto = new ErrorHanlderdto();
//        errorHanlderdto.setErrorMessage("Product not found");
//        return new ResponseEntity(errorHanlderdto, HttpStatus.NOT_FOUND);
//    }


}
