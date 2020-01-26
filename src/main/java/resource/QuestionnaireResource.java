package resource;

import controller.QuestionnaireController;
import model.Question;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Map;

@Path("/questionnaire")
public class QuestionnaireResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Map<Integer, Question> getAllQuestions() {
        return QuestionnaireController.getAllQuestions();
    }

    @GET
    @Path("/{questionId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Question getQuestionById(@PathParam("questionId") int questionId) {
        return QuestionnaireController.getQuestionById(questionId);
    }

    @GET
    @Path("/answers")
    @Produces(MediaType.APPLICATION_JSON)
    public Map<Integer, Integer> getAllAnswers() {
        return QuestionnaireController.getAnswers();
    }

    @PUT
    @Path("/{questionId}/{answerId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void addAnswer(@PathParam("questionId") int questionId,
                          @PathParam("answerId") int answerId) {
        QuestionnaireController.setAnswer(questionId, answerId);
    }
}