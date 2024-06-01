package dev.raj.industrylevelproject.Services.FakeStoreServices;

import dev.raj.industrylevelproject.Clients.FakeStoreClient;
import dev.raj.industrylevelproject.Clients.FakeStoreproductDto;
import org.springframework.stereotype.Service;

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
