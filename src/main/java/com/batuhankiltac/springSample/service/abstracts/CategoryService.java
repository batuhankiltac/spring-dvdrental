package com.batuhankiltac.springSample.service.abstracts;

import com.batuhankiltac.springSample.domain.Category;
import com.batuhankiltac.springSample.model.CategoryDto;

import java.util.List;

public interface CategoryService {
    void add(CategoryDto categoryDto);
    void delete(Integer id);
    List<Category> getAll();
    List<Category> getAllByPage(Integer pageNumber, Integer pageSize);
    List<Category> getAllSortedByID();
    List<Category> getAllSortedByName();
    Category getByCategoryId(Integer categoryId);
}