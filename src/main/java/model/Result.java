package model;

/**
 * The enum class which represents the result of questionnaire as String.
 *
 * @author  Aleksei Piatkin
 * @version 1.0
 * @since   2020-01-26
 */
public enum Result {

    BAD("Unfortunately, we don’t match!"),
    GOOD("That looks good!"),
    EXCELLENT("Excellent!!!");

    private final String result;

    Result (final String result){
        assert result != null;
        this.result = result;
    }

    /**
     * @return the result as a plain text.
     */
    public String getResult() {
        return result;
    }
}
