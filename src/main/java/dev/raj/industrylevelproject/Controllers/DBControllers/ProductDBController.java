package dev.raj.industrylevelproject.Controllers.DBControllers;


import dev.raj.industrylevelproject.Clients.AuthClient;
import dev.raj.industrylevelproject.Clients.FakeStoreproductDto;
import dev.raj.industrylevelproject.DTOs.*;
import dev.raj.industrylevelproject.Exceptions.NotFoundException;
import dev.raj.industrylevelproject.Exceptions.ProductNotFoundException;
import dev.raj.industrylevelproject.Models.Category;
import dev.raj.industrylevelproject.Models.Product;
import dev.raj.industrylevelproject.Models.SessionStatus;
import dev.raj.industrylevelproject.Services.FakeStoreServices.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/items")
public class ProductDBController {
  //@Qualifier says i have given name to each service implementation one is fakestore antoehr one is
    //db so use whichever service u want by annotating @Qualifier to productservice or else it get
    //confused which service to use

    ProductService productService;
    AuthClient authClient;
    public ProductDBController(@Qualifier("ProductDBImple") ProductService productService,AuthClient authClient){
        this.productService = productService;
        this.authClient = authClient;
    }

    public ProductDBDto convertFakeStoreProductDtoToProduct(Product productDto1){
        ProductDBDto product  = new ProductDBDto();
        product.setTitle(productDto1.getTitle());
        product.setPrice(productDto1.getPrice());
        product.setDescription(productDto1.getDescription());
        product.setCategory(productDto1.getCategory().getName());
        product.setImage(productDto1.getImage());
        return  product;
    }


    //@Nullable even if the parameter is null it will not throw any error
    @GetMapping()//if the url is /products then this method will be called
    public ResponseEntity<List<Product>> getAllProducts( @Nullable  @RequestHeader("AUTH_TOKEN") String token,
                                                         @Nullable @RequestHeader("USER_ID") Long id){

        if(token == null || id == null){
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

          ResponseEntity<ValidateResponseDto> response = authClient.validate(token, id);
        if(response.getBody().getStatus().equals(SessionStatus.INVALID)){
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        boolean isUserAdmin = false;
        for(Role role: response.getBody().getUserDto().getRoles()){
            if(role.getRole().equals("ADMIN")){
                isUserAdmin = true;
                break;
            }
        }
        if(!isUserAdmin){
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        List<Product> products = productService.getAllProducts();
//        List<ProductDBDto> productDBDtos = new ArrayList<>();
//        for(Product product: products){
//           ProductDBDto productDBDto =  convertFakeStoreProductDtoToProduct(product);
//              productDBDtos.add(productDBDto);
//        }


        return new ResponseEntity<>(products, HttpStatus.OK);
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
