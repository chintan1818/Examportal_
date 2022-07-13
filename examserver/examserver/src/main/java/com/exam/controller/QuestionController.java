package com.exam.controller;

import com.exam.model.exam.Question;
import com.exam.model.exam.Quiz;
import com.exam.service.QuestionService;
import com.exam.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @Autowired
    private QuizService quizService;

    //add question
    @PostMapping("/")
    public ResponseEntity<Question> addQuestion(@RequestBody Question question)
    {
        return ResponseEntity.ok(questionService.addQuestion(question));
    }

    //update question
    @PutMapping("/")
    public ResponseEntity<Question> updateQuestion(@RequestBody Question question)
    {
        return ResponseEntity.ok(questionService.updateQuestion(question));
    }

    //get questionzes
    @GetMapping("/")
    public ResponseEntity<?> getquestiones()
    {
        return ResponseEntity.ok(questionService.getQuestions());
    }

    //get single question
    @GetMapping("/{questionId}")
    public Question getQuestion(@PathVariable("questionId") Long questionId)
    {
        return questionService.getQuestion(questionId);
    }

    //get  question of any quiz
    @GetMapping("/quiz/{quizId}")
    public ResponseEntity<?> getQuestionsOfQuiz(@PathVariable("quizId") long quizId )
    {
//        Quiz quiz=new Quiz();
//        quiz.setqId(quizId);
//        Set<Question> questionsOfQuiz = questionService.getQuestionsOfQuiz(quiz);
//        return ResponseEntity.ok(questionsOfQuiz);

        Quiz quiz = quizService.getQuiz(quizId);
        Set<Question> questions = quiz.getQuestions();
        List list = new ArrayList(questions);
        System.out.println(quiz.getNumberOfQuestions());
        if(list.size()>Integer.parseInt(quiz.getNumberOfQuestions()))
        {
            list=list.subList(0,Integer.parseInt(quiz.getNumberOfQuestions())+1);

        }
        System.out.println(list.toString());
        Collections.shuffle(list);
        return ResponseEntity.ok(list);


    }

    //get  question of any quiz
    @GetMapping("/quiz/all/{quizId}")
    public ResponseEntity<?> getAllQuestionsOfQuiz(@PathVariable("quizId") long quizId )
    {
        Quiz quiz=new Quiz();
        quiz.setqId(quizId);
        Set<Question> questionsOfQuiz = questionService.getQuestionsOfQuiz(quiz);
        return ResponseEntity.ok(questionsOfQuiz);

    }




    //delete question
    @DeleteMapping("/{questionId}")
    public void deleteQuestion(@PathVariable("questionId") Long questionId)
    {
        questionService.deleteQuestion(questionId);
    }
}
