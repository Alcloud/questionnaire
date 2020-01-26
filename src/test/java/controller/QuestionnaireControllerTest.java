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
        QuestionnaireController.setAnswer(inputId, inputValue);

        final boolean idExist = QuestionnaireController.getAnswers().containsKey(inputId);
        final int actualValue = QuestionnaireController.getAnswers().get(inputId);
        final int actualSize = QuestionnaireController.getAnswers().size();

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
        QuestionnaireController.setAnswer(inputIdOne, inputValueOne);
        QuestionnaireController.setAnswer(inputIdTwo, inputValueTwo);
        QuestionnaireController.setAnswer(inputIdThree, inputValueThree);

        final String actualResult = QuestionnaireController.getResult();

        assertEquals(expectedResult, actualResult, "Result didn't match");
    }
}