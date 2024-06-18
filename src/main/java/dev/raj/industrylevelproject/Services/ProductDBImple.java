package dev.raj.industrylevelproject.Services;

import dev.raj.industrylevelproject.Clients.FakeStoreproductDto;
//import dev.raj.industrylevelproject.Controllers.DBControllers.ProductNotFoundException;
import dev.raj.industrylevelproject.DTOs.productDto;
import dev.raj.industrylevelproject.Exceptions.NotFoundException;
import dev.raj.industrylevelproject.Models.Category;
import dev.raj.industrylevelproject.Models.Product;
import dev.raj.industrylevelproject.Repositories.ProductDBRepository;
import dev.raj.industrylevelproject.Services.FakeStoreServices.ProductService;
import jakarta.transaction.Transactional;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.print.attribute.standard.PageRanges;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service("ProductDBImple")
@Primary
public class ProductDBImple implements ProductService {

    ProductDBRepository productDBRepository;


    public ProductDBImple(ProductDBRepository productDBRepository){
        this.productDBRepository = productDBRepository;

    }



    @Override
    public List<Product> getAllProducts() {


            List<Product> products=  productDBRepository.findAllproduct();

            return products;

    }

    @Override
    public Optional<Product> getProductById(Long id) throws NotFoundException{
       Product product =  productDBRepository.findProductById(id);
       if(product == null){
              throw new NotFoundException("Product not found");
       }
       return Optional.of(product);
    }

    @Override
    public Product addProduct(Product product) {
       Product product1=  productDBRepository.save(product);
     return  product1;
    }

    @Override
    public ResponseEntity<FakeStoreproductDto> updateProduct(Long ProductId,Product product) throws NotFoundException {
       Product productfind = productDBRepository.findProductById(ProductId);
       if(productfind == null) {
           throw new NotFoundException( "Product not found");
       }
        productfind.setTitle(product.getTitle());
        productfind.setPrice(product.getPrice());
        productfind.setDescription(product.getDescription());
        productfind.setImage(product.getImage());


      Product productup = productDBRepository.save(productfind);
     FakeStoreproductDto fakeStoreproductDto = new FakeStoreproductDto();
     fakeStoreproductDto.setPrice(productup.getPrice());
        fakeStoreproductDto.setTitle(productup.getTitle());
        fakeStoreproductDto.setCategory(productup.getCategory().getName());
        return ResponseEntity.ok(fakeStoreproductDto);
    }

    @Transactional
    @Override
    public void deleteProduct(Long id){
         productDBRepository.deleteProductById(id);

    }

    @Override
    public Product replaceProduct(Long productId, productDto productDto) {
        return null;
    }


    @Override
    public Page<Product> searchProducts(String searchTerm, int NumberOfproduct, int offset) {
        //pageable is an interface we could implement that inferface and use it here
        //this pageable provides all the metadata like is this the last page, pages, total number of pages etc
        // but we have helper method in PageRequest class to implement pageable
        //offset starts from 0
        //offset is the number of products we want to skip/number of products we want to show gives the page number

       Page<Product> response = productDBRepository.findAllByTitle(searchTerm, PageRequest.of(offset/NumberOfproduct, NumberOfproduct));
        return null;
    }
}
//errors
//1. run two microservice