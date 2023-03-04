package com.batuhankiltac.springSample.controller;

import com.batuhankiltac.springSample.domain.Category;
import com.batuhankiltac.springSample.model.CategoryDto;
import com.batuhankiltac.springSample.service.abstracts.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping
    public void add(@RequestBody CategoryDto categoryDto) {
        categoryService.add(categoryDto);
    }

    @DeleteMapping
    public void delete(@RequestParam Integer id) {
        categoryService.delete(id);
    }

    @GetMapping
    public List<Category> getAll() {
        return categoryService.getAll();
    }

    @GetMapping("/by-page")
    public List<Category> getAllByPage(@RequestParam Integer pageNumber, @RequestParam Integer pageSize) {
        return categoryService.getAllByPage(pageNumber, pageSize);
    }

    @GetMapping("/sorted-by-id")
    public List<Category> getAllSortedByID() {
        return categoryService.getAllSortedByID();
    }

    @GetMapping("/sorted-by-name")
    public List<Category> getAllSortedByName() {
        return categoryService.getAllSortedByName();
    }

    @GetMapping("/by-category-id")
    public Category getByCategoryId(@RequestParam Integer categoryId) {
        return categoryService.getByCategoryId(categoryId);
    }
}