package com.exam.service;

import com.exam.model.exam.Category;
import com.exam.model.exam.Quiz;

import java.util.Set;

public interface QuizService {

    public Quiz addQuiz(Quiz quiz);
    public Quiz updateQuiz(Quiz quiz);
    public Set<Quiz> getQuizes();
    public Quiz getQuiz(long quizId);
    public void deleteById(long quizId);

    public Set<Quiz> getQuizesOfcategory(Category category);

    public Set<Quiz> getActiveQuizes();

    public Set<Quiz> getActiveQuizesOfCategoty(Category category);




}
