package com.exam.service.impl;

import com.exam.model.exam.Category;
import com.exam.model.exam.Quiz;
import com.exam.repo.QuizRepository;
import com.exam.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class QuizServiceImpl implements QuizService {

    @Autowired
    QuizRepository quizRepository;


    @Override
    public Quiz addQuiz(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    @Override
    public Quiz updateQuiz(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    @Override
    public Set<Quiz> getQuizes() {
        return new HashSet<>(quizRepository.findAll());
    }

    @Override
    public Quiz getQuiz(long quizId) {
        return quizRepository.findById(quizId).get();
    }

    @Override
    public void deleteById(long quizId) {

        quizRepository.deleteById(quizId);
    }

    @Override
    public Set<Quiz> getQuizesOfcategory(Category category) {
        return quizRepository.findBycategory(category);
    }

    @Override
    public Set<Quiz> getActiveQuizes() {
        return quizRepository.findByActive(true);
    }

    @Override
    public Set<Quiz> getActiveQuizesOfCategoty(Category category) {
        return quizRepository.findByCategoryAndActive(category,true);
    }


}
