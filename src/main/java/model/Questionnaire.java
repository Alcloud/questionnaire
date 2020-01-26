package model;

import util.Props;

import java.util.HashMap;
import java.util.Map;

/**
 * The questionnaire class fills out the questionnaire with questions.
 *
 * @author  Aleksei Piatkin
 * @version 1.0
 * @since   2020-01-26
 */
public class Questionnaire {

    private static Map<Integer, Question> questions;

    public Questionnaire() {
        questions = new HashMap<>();

        // Set the first question
        Map<Integer, Question.AnswerChoice> answerChoiceOne = new HashMap<>();

        answerChoiceOne.put(1, new Question.AnswerChoice(Props.getProperties().getProperty("ANSWER_ONE_QUESTION_ONE"), 5));
        answerChoiceOne.put(2, new Question.AnswerChoice(Props.getProperties().getProperty("ANSWER_TWO_QUESTION_ONE"), 3));
        answerChoiceOne.put(3, new Question.AnswerChoice(Props.getProperties().getProperty("ANSWER_THREE_QUESTION_ONE"), 0));

        questions.put(1, new Question(Props.getProperties().getProperty("QUESTION_ONE_TEXT"), answerChoiceOne));


        // Set the second question
        Map<Integer, Question.AnswerChoice> answerChoiceTwo = new HashMap<>();

        answerChoiceTwo.put(1, new Question.AnswerChoice(Props.getProperties().getProperty("ANSWER_ONE_QUESTION_TWO"), 0));
        answerChoiceTwo.put(2, new Question.AnswerChoice(Props.getProperties().getProperty("ANSWER_TWO_QUESTION_TWO"), 1));
        answerChoiceTwo.put(3, new Question.AnswerChoice(Props.getProperties().getProperty("ANSWER_THREE_QUESTION_TWO"), 3));
        answerChoiceTwo.put(4, new Question.AnswerChoice(Props.getProperties().getProperty("ANSWER_FOUR_QUESTION_TWO"), 5));

        questions.put(2, new Question(Props.getProperties().getProperty("QUESTION_TWO_TEXT"), answerChoiceTwo));


        // Set the third question
        Map<Integer, Question.AnswerChoice> answerChoiceThree = new HashMap<>();

        answerChoiceThree.put(1, new Question.AnswerChoice(Props.getProperties().getProperty("ANSWER_ONE_QUESTION_THREE"), 3));
        answerChoiceThree.put(2, new Question.AnswerChoice(Props.getProperties().getProperty("ANSWER_TWO_QUESTION_THREE"), 0));

        questions.put(3, new Question(Props.getProperties().getProperty("QUESTION_THREE_TEXT"), answerChoiceThree));
    }

    /**
     * @return the questions as a Map.
     */
    public static Map<Integer, Question> getQuestions() {
        return questions;
    }
}
