package dev.raj.industrylevelproject.Services;

import dev.raj.industrylevelproject.Clients.FakeStoreClient;
import dev.raj.industrylevelproject.Clients.FakeStoreproductDto;
import dev.raj.industrylevelproject.DTOs.FakeStoreCategoryDto;
import dev.raj.industrylevelproject.Models.Category;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service //creates object of the class can find in actuator it is service so using @Service
public class CategoryServiceImple implements CategoryService{

    FakeStoreClient fakeStoreClient;
    public CategoryServiceImple(FakeStoreClient fakeStoreClient){
        this.fakeStoreClient = fakeStoreClient;
    }

    @Override
    public List<String> getAllCategories() {

        List<String> fakeStoreCategory = fakeStoreClient.getallCategories();

        return fakeStoreCategory;
    }

    @Override
    public List<FakeStoreproductDto> getProductInCategory(String  name) {
        List<FakeStoreproductDto> fakeStoreCategoryDto = fakeStoreClient.getProductsInCategory(name);
        return fakeStoreCategoryDto;
    }
}
