package dev.raj.industrylevelproject.Services;

import dev.raj.industrylevelproject.Clients.FakeStoreproductDto;
import dev.raj.industrylevelproject.Repositories.CategoryDBRepository;

import java.util.List;

public class CategoryDBImple implements CategoryService{

    CategoryDBRepository categoryDBRepository;

    public CategoryDBImple(CategoryDBRepository categoryDBRepository){
        this.categoryDBRepository = categoryDBRepository;
    }

    @Override
    public List<String> getAllCategories() {
        return null;
    }

    @Override
    public List<FakeStoreproductDto> getProductInCategory(String id) {

        return null;
    }
}
