package com.batuhankiltac.springSample.service.concretes;

import com.batuhankiltac.springSample.converter.CategoryConverter;
import com.batuhankiltac.springSample.domain.Category;
import com.batuhankiltac.springSample.model.CategoryDto;
import com.batuhankiltac.springSample.repository.CategoryRepository;
import com.batuhankiltac.springSample.service.abstracts.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryManager implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryConverter categoryConverter;

    @Override
    public void add(CategoryDto categoryDto) {
        Category category = categoryConverter.convert(categoryDto);
        categoryRepository.save(category);
    }

    @Override
    public void delete(Integer id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public List<Category> getAllByPage(Integer pageNumber, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize);
        return categoryRepository.findAll(pageable).getContent();
    }

    @Override
    public List<Category> getAllSortedByID() {
        Sort sort = Sort.by(Sort.Direction.ASC, "categoryId");
        return categoryRepository.findAll(sort);
    }

    @Override
    public List<Category> getAllSortedByName() {
        Sort sort = Sort.by(Sort.Direction.ASC, "categoryName");
        return categoryRepository.findAll(sort);
    }

    @Override
    public Category getByCategoryId(Integer categoryId) {
        return categoryRepository.getByCategoryId(categoryId);
    }
}