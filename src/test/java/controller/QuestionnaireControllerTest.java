package controller;

import model.Questionnaire;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuestionnaireControllerTest {

    @Test
    void setAnswers() {

        final int inputId = 1;
        final int inputValue = 1;

        final int expectedValue = inputValue;
        final int expectedSize = 1;

        new Questionnaire();

        QuestionnaireController.clearAnswerDB();
        QuestionnaireController.setAnswers(inputId, inputValue);

        final boolean idExist = QuestionnaireController.getAnswersDB().containsKey(inputId);
        final int actualValue = QuestionnaireController.getAnswersDB().get(inputId);
        final int actualSize = QuestionnaireController.getAnswersDB().size();

        assertTrue(idExist, "ID didn't match or exist");
        assertEquals(expectedValue, actualValue, "Value didn't match");
        assertEquals(expectedSize, actualSize, "Size didn't match");
    }

    @Test
    void getResult() {

        final int inputIdOne = 1;
        final int inputValueOne = 1;
        final int inputIdTwo = 2;
        final int inputValueTwo = 4;
        final int inputIdThree = 3;
        final int inputValueThree = 1;

        final String expectedResult = "Excellent!!!";

        new Questionnaire();

        QuestionnaireController.clearAnswerDB();
        QuestionnaireController.setAnswers(inputIdOne, inputValueOne);
        QuestionnaireController.setAnswers(inputIdTwo, inputValueTwo);
        QuestionnaireController.setAnswers(inputIdThree, inputValueThree);

        final String actualResult = QuestionnaireController.getResult();

        assertEquals(expectedResult, actualResult, "Result didn't match");
    }
}