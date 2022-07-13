package com.exam.repo;

import com.exam.model.exam.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface CategoryRepository extends JpaRepository<Category,Long> {
}
