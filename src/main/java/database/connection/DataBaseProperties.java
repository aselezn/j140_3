package database.connection;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DataBaseProperties extends Properties {

    private static DataBaseProperties dbp;

    private DataBaseProperties() {
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("application.properties")) {
            if (input != null) {
                load(input);
            } else {

                throw new IOException("application.properties not found");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static DataBaseProperties get() {
        if (dbp == null) {
            dbp = new DataBaseProperties();
        }
        return dbp;
    }

}
