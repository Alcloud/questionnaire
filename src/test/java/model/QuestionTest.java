package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuestionTest {

    @Test
    void getQuestionTitle() {
        new Questionnaire();

        final int inputQuestionId = 1;
        final String expectedTitle = "Do you enjoy working in a team?";

        Question question = Questionnaire.getQuestions().get(inputQuestionId);
        final String actualTitle = question.getQuestionTitle();

        assertEquals(expectedTitle, actualTitle, "Titles didn't match");
    }

    @Test
    void getAnswerChoice() {
        final int inputQuestionId = 2;
        final int inputAnswerId = 3;

        final int expectedSize = 4;
        final String expectedAnswerText = "Less than 2 year";
        final int expectedAnswerPoint = 3;

        new Questionnaire();

        Question question = Questionnaire.getQuestions().get(inputQuestionId);
        final int actualSize = question.getAnswerChoice().size();
        final String actualAnswerText = question.getAnswerChoice().get(inputAnswerId).getAnswerText();
        final int actualAnswerPoint = question.getAnswerChoice().get(inputAnswerId).getPoint();

        assertEquals(expectedSize, actualSize, "Size didn't match");
        assertEquals(expectedAnswerText, actualAnswerText, "Answers didn't match");
        assertEquals(expectedAnswerPoint, actualAnswerPoint, "Points didn't match");
    }

    @Test
    void getAnswerText() {
        new Questionnaire();

        final int inputQuestionId = 1;
        final int inputAnswerId = 3;
        final String expectedAnswerText = "I prefer to work alone";

        Question question = Questionnaire.getQuestions().get(inputQuestionId);
        Question.AnswerChoice answerChoice = question.getAnswerChoice().get(inputAnswerId);

        final String actualAnswerText = answerChoice.getAnswerText();

        assertEquals(expectedAnswerText, actualAnswerText, "Titles didn't match");
    }

    @Test
    void getPoint() {
        new Questionnaire();

        final int inputQuestionId = 1;
        final int inputAnswerId = 3;
        final int expectedPoint = 0;

        Question question = Questionnaire.getQuestions().get(inputQuestionId);
        Question.AnswerChoice answerChoice = question.getAnswerChoice().get(inputAnswerId);

        final int actualPoint = answerChoice.getPoint();

        assertEquals(expectedPoint, actualPoint, "Points didn't match");
    }
}