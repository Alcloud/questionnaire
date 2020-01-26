package model;

import java.util.Map;

/**
 * The question class represent a model for a single question of questionnaire.
 *
 * @author  Aleksei Piatkin
 * @version 1.0
 * @since   2020-01-26
 */

public class Question {

    private String questionTitle;
    private Map<Integer, AnswerChoice> answerChoice;

    Question(String questionTitle, Map<Integer, AnswerChoice> answerChoice){
        this.questionTitle = questionTitle;
        this.answerChoice = answerChoice;
    }

    /**
     * @return the question as a plain text.
     */
    public String getQuestionTitle() {
        return questionTitle;
    }

    /**
     * @return the answer choices as a Map.
     */
    public Map<Integer, AnswerChoice> getAnswerChoice() {
        return answerChoice;
    }

    /**
     * The inner class represent a model for an answer choice of question.
     */
    public static class AnswerChoice {

        private String answerText;
        private int point;

        AnswerChoice(String answerText, int point) {
            this.answerText = answerText;
            this.point = point;
        }

        /**
         * @return the answer as a plain text.
         */
        public String getAnswerText() {
            return answerText;
        }

        /**
         * @return the point for the current answer.
         */
        public int getPoint() {
            return point;
        }
    }
}
