package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * The class which helps to retrieve properties from the file.
 *
 * @author  Aleksei Piatkin
 * @version 1.0
 * @since   2020-01-26
 */

public class Props {

    private static final String PATH_TO_PROPERTIES = "src/main/resources/config.properties";

    public static Properties getProperties(){
        Properties appProps = new Properties();

        try {
            appProps.load(new FileInputStream(PATH_TO_PROPERTIES));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return appProps;
    }
}