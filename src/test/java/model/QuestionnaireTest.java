package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuestionnaireTest {

    @Test
    void getQuestions() {
        final int inputQuestionId = 3;

        final int expectedSize = 3;
        final String expectedQuestionTitle = "How do you feel about automated tests?";

        new Questionnaire();

        final int actualSize = Questionnaire.getQuestions().size();
        final String actualQuestionTitle = Questionnaire.getQuestions().get(inputQuestionId).getQuestionTitle();

        assertEquals(expectedQuestionTitle, actualQuestionTitle, "Titles didn't match");
        assertEquals(expectedSize, actualSize, "Size didn't match");
    }
}