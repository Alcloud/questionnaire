package controller;

import model.Question;
import model.Questionnaire;
import model.Result;

import java.util.HashMap;
import java.util.Map;

/**
 * The controller class saves the answers as Map and
 * calculates the point result
 *
 * @author Aleksei Piatkin
 * @version 1.0
 * @since 2020-01-26
 */

public class QuestionnaireController {

    private static int MAX_POINTS = 9;
    private static int MIDDLE_POINTS = 7;

    private static Map<Integer, Integer> answersDB = new HashMap<>();

    /**
     * Save answers in Map "database"
     *
     * @param questionId - question id
     * @param answerId   - answer id
     */
    public static void setAnswer(int questionId, int answerId) {
        answersDB.put(questionId, answerId);
    }

    /**
     * @return Map of answers
     */
    public static Map<Integer, Integer> getAnswers() {
        return answersDB;
    }

    /**
     * @param questionId - question id.
     * @return the question by the question id.
     */
    public static Question getQuestionById(int questionId) {
        return Questionnaire.getQuestions().get(questionId);
    }

    /**
     * @return the questions as a Map.
     */
    public static Map<Integer, Question> getAllQuestions() {
        return Questionnaire.getQuestions();
    }

    /**
     * Clear answers Map "database"
     */
    public static void clearAnswerDB() {
        answersDB.clear();
    }

    /**
     * @return points result
     */
    public static String getResult() {
        int point = 0;

        for (Map.Entry entry : getAnswers().entrySet()) {
            int key = entry.getKey().hashCode();
            int value = entry.getValue().hashCode();

            // get question to retrieve the points
            Question question = getQuestionById(key);

            // calculate total points from every question
            point += question.getAnswerChoice().get(value).getPoint();
        }

        if (point < MIDDLE_POINTS) {
            return Result.BAD.getResult();
        } else if (point > MAX_POINTS) {
            return Result.EXCELLENT.getResult();
        } else {
            return Result.GOOD.getResult();
        }
    }
}