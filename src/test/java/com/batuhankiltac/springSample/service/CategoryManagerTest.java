package com.batuhankiltac.springSample.service;

import com.batuhankiltac.springSample.converter.CategoryConverter;
import com.batuhankiltac.springSample.domain.Category;
import com.batuhankiltac.springSample.model.CategoryDto;
import com.batuhankiltac.springSample.repository.CategoryRepository;
import com.batuhankiltac.springSample.service.concretes.CategoryManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(MockitoJUnitRunner.Silent.class)
public class CategoryManagerTest {

    @InjectMocks
    private CategoryManager categoryManager;

    @Mock
    private CategoryRepository categoryRepository;

    @Mock
    private CategoryConverter categoryConverter;

    @Test
    public void it_should_save_category() {
        // Given
        final CategoryDto categoryDto = CategoryDto.builder().build();
        final Category category = Category.builder().build();
        when(categoryConverter.convert(categoryDto)).thenReturn(category);

        // When
        categoryManager.add(categoryDto);

        // Then
        verify(categoryConverter).convert(categoryDto);
        verify(categoryRepository).save(category);
    }

    @Test
    public void it_should_delete_category() {
        // Given
        final Integer id = 1;

        // When
        categoryManager.delete(id);

        // Then
        verify(categoryRepository).deleteById(id);
    }

    @Test
    public void it_should_get_all_categories() {
        // Given
        final Category category1 = Category.builder()
                .categoryId(1)
                .categoryName("test1")
                .build();
        final Category category2 = Category.builder()
                .categoryId(2)
                .categoryName("test2")
                .build();
        final List<Category> categories = Arrays.asList(category1, category2);

        // When
        categoryManager.getAll();

        // Then
        verify(categoryRepository).findAll();
        assertThat(categories).isNotEmpty();
    }

    @Test
    public void it_should_get_category_by_category_id() {
        // Given
        final Category category = Category.builder()
                .categoryId(1)
                .categoryName("test1")
                .build();

        // When
        categoryManager.getByCategoryId(category.getCategoryId());

        // Then
        verify(categoryRepository).getByCategoryId(category.getCategoryId());
    }
}