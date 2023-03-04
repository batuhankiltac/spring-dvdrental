package com.batuhankiltac.springSample.repository;

import com.batuhankiltac.springSample.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Category getByCategoryId(Integer categoryId);
}