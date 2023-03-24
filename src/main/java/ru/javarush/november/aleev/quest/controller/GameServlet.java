package ru.javarush.november.aleev.quest.controller;

import ru.javarush.november.aleev.quest.entity.Answer;
import ru.javarush.november.aleev.quest.entity.Game;
import ru.javarush.november.aleev.quest.entity.GameState;
import ru.javarush.november.aleev.quest.service.GameService;
import ru.javarush.november.aleev.quest.service.QuestionService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.stream.Collectors;

@WebServlet(name = "gameServlet", value = "/game")
public class GameServlet extends HttpServlet {
    private final GameService gameService = GameService.INSTANCE;
    private final QuestionService questionService = QuestionService.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long currentQuestionId = gameService.get((Long) req.getSession().getAttribute("id")).getCurrentQuestionId();
        if (req.getParameter("answer") != null) {
            if (req.getParameter("answer").equals("0")) {
                Answer answer = questionService.get(currentQuestionId).getAnswers().stream().collect(Collectors.toList()).get(0);
                req.getSession().setAttribute("correct", answer.getIsCorrect());
                currentQuestionId = answer.getNextQuestionId();
            } else {
                Answer answer = questionService.get(currentQuestionId).getAnswers().stream().collect(Collectors.toList()).get(1);
                req.getSession().setAttribute("correct", answer.getIsCorrect());
                currentQuestionId = answer.getQuestionId();
            }
            gameService.get((Long) req.getSession().getAttribute("id")).setCurrentQuestionId(currentQuestionId);
        }

        nextStep(req, resp, currentQuestionId);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("game.jsp");
        requestDispatcher.forward(req, resp);
    }

    private void nextStep(HttpServletRequest req, HttpServletResponse resp, Long currentQuestionId) throws ServletException, IOException{
        req.setAttribute("questionText", questionService.get(currentQuestionId).getAnswers());
        Collection<Answer> answers = questionService.get(currentQuestionId).getAnswers();
        Game game = gameService.get((Long) req.getSession().getAttribute("id"));

        if(answers == null){
            if (req.getSession().getAttribute("correct") == null){
                game.setState(GameState.WIN);
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("win.jsp");
                requestDispatcher.forward(req,resp);
            } else {
                game.setState(GameState.LOSE);
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("lose.jsp");
                requestDispatcher.forward(req,resp);
            }
        }
        req.setAttribute("answer1", answers.stream().collect(Collectors.toList()).get(0).getText());
        req.setAttribute("answer2", answers.stream().collect(Collectors.toList()).get(1).getText());
    }
}
