package view;

import controller.QuestionnaireController;
import model.Question;
import model.Questionnaire;

import java.util.Map;
import java.util.Scanner;

/**
 * The ConsoleView class which shows UI, questionnaire and result in the console.
 *
 * @author Aleksei Piatkin
 * @version 1.0
 * @since 2020-01-26
 */

public class ConsoleView {

    private Scanner scanner;

    public ConsoleView() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * shows the questionnaire and UI
     */
    public void show() {
        String name = askName("name");
        String surname = askName("surname");

        showGreeting(name, surname);

        showQuestions();

        showResult();
    }

    /**
     * shows the greeting in console
     */
    private void showGreeting(String name, String surname) {
        System.out.format("Hello, %s %s. Welcome to the questionnaire!\n", name, surname);
    }

    /**
     * shows the questions in console
     */
    private void showQuestions() {
        // Clear the answer DB
        QuestionnaireController.clearAnswerDB();

        // step counter
        int count = 1;

        while (count <= Questionnaire.getQuestions().size()) {
            printQuestion(count);

            // retrieve user answer
            int answer = askAnswer();

            // back to the previous question
            if (answer == 0) {
                if (count != 1) {
                    count--;
                }

                // answer on the question
            } else if (answer > 0 && answer <= Questionnaire.getQuestions().get(count).getAnswerChoice().size()) {
                QuestionnaireController.setAnswers(count, answer);
                count++;

                // enter the illegal answer
            } else {
                System.out.println("Wrong command, try again.");
            }
        }
    }

    /**
     * print the question text
     */
    private void printQuestion(int questionId) {
        Question question = Questionnaire.getQuestions().get(questionId);

        System.out.format("\n%s question:\n", questionId);
        System.out.println(question.getQuestionTitle());

        for (Map.Entry entry : question.getAnswerChoice().entrySet()) {
            Question.AnswerChoice answerChoice = (Question.AnswerChoice) entry.getValue();

            System.out.format("- %s (press %s)\n", answerChoice.getAnswerText(), entry.getKey());
        }
        if (questionId > 1) {
            System.out.println("<- previous question: press 0");
        }
    }

    /**
     * shows result info in console
     */
    private void showResult() {
        System.out.println("\n" + QuestionnaireController.getResult());
    }

    /**
     * @return entered user name
     */
    private String askName(String name) {
        System.out.format("Enter your %s: ", name);
        return scanner.next();
    }

    /**
     * @return entered user answer as integer
     */
    private int askAnswer() {
        System.out.print("\nEnter your answer: ");
        while (!scanner.hasNext("[0-9]")) {
            System.out.println("Wrong command, try again.");
            scanner.next();
        }
        return scanner.nextInt();
    }
}
