package com.exam.repo;

import com.exam.model.exam.Category;
import com.exam.model.exam.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public interface QuizRepository extends JpaRepository<Quiz,Long> {
    Set<Quiz> findBycategory(Category category);
    // void deleteById(long quizId) ;

    Set<Quiz> findByActive(boolean b);


    Set<Quiz> findByCategoryAndActive(Category category, Boolean b);
}
