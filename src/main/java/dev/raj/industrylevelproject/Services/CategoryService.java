package dev.raj.industrylevelproject.Services;

import dev.raj.industrylevelproject.Clients.FakeStoreproductDto;
import dev.raj.industrylevelproject.DTOs.FakeStoreCategoryDto;
import dev.raj.industrylevelproject.Models.Category;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CategoryService {

    public List<String> getAllCategories();
    public List<FakeStoreproductDto> getProductInCategory(String id);

}
