import model.Questionnaire;
import view.ConsoleView;

/**
 * The main app class.
 *
 * @author  Aleksei Piatkin
 * @version 1.0
 * @since   2020-01-26
 */
public class App {

    public static void main(String[] args){

        new Questionnaire();
        ConsoleView consoleView = new ConsoleView();
        consoleView.show();
    }
}
