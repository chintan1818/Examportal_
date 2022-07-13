package com.exam.controller;

import com.exam.model.exam.Category;
import com.exam.model.exam.Quiz;
import com.exam.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;

@RestController
@CrossOrigin("*")
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    //add quiz
    @PostMapping("/")
    public ResponseEntity<Quiz> addQuiz(@RequestBody  Quiz quiz)
    {
        return ResponseEntity.ok(quizService.addQuiz(quiz));
    }

    //update quiz
    @PutMapping("/")
    public ResponseEntity<Quiz> updateQuiz(@RequestBody Quiz quiz)
    {
        return ResponseEntity.ok(quizService.updateQuiz(quiz));
    }

    //get quizzes
    @GetMapping("/")
    public ResponseEntity<?> quizes()
    {
        return ResponseEntity.ok(quizService.getQuizes());
    }

    //get single quiz
    @GetMapping("/{quizId}")
    public Quiz getQuiz(@PathVariable("quizId") Long quizId)
    {
        return quizService.getQuiz(quizId);
    }

    //delete quiz
    @DeleteMapping("/{quizId}")
    public void deleteQuiz(@PathVariable("quizId") Long quizId)
    {
        quizService.deleteById(quizId);
    }

    @GetMapping("/category/{cId}")
    public ResponseEntity<?> getQuizesOfCategory(@PathVariable("cId") Long catId)
    {
        Category category = new Category();
        category.setcId(catId);
        return ResponseEntity.ok(quizService.getQuizesOfcategory(category));
    }

    @GetMapping("/active")
    public HashSet<Quiz> getQuizesOfCategory()
    {

        return new HashSet<Quiz>(quizService.getActiveQuizes()) ;
    }

    @GetMapping("/category/active/{cId}")
    public ResponseEntity<?> getActiveQuizesOfCategory(@PathVariable("cId") Long catId)
    {
        Category category = new Category();
        category.setcId(catId);
        return ResponseEntity.ok(quizService.getActiveQuizesOfCategoty(category));
    }



}
