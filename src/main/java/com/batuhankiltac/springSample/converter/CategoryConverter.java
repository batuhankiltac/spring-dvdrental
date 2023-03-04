package com.batuhankiltac.springSample.converter;

import com.batuhankiltac.springSample.domain.Category;
import com.batuhankiltac.springSample.model.CategoryDto;
import org.springframework.stereotype.Component;

@Component
public class CategoryConverter {

    public Category convert(CategoryDto categoryDto) {
        return Category.builder()
                .categoryId(categoryDto.getCategoryId())
                .categoryName(categoryDto.getCategoryName())
                .build();
    }
}
