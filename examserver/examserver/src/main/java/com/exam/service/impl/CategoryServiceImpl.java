package com.exam.service.impl;

import com.exam.model.exam.Category;
import com.exam.repo.CategoryRepository;
import com.exam.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public Category addCategory(Category category) {
        return this.categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Set<Category> getCategories() {
        return  new HashSet<>(categoryRepository.findAll());
    }

    @Override
    public Category getCategory(Long categoryId) {
        return categoryRepository.findById(categoryId).get();
    }

    @Override
    public void deleteCategory(Long categoryId) {

        categoryRepository.deleteById(categoryId);
    }
}
