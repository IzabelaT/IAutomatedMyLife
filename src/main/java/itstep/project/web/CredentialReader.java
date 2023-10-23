package itstep.project.web;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class CredentialReader {
    private Properties properties;
    private static final String USERNAME_PROPERTY = "username";
    private static final String PASSWORD_PROPERTY = "password";

    public CredentialReader(String filePath) {
        properties = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream(filePath);
            properties.load(fileInputStream);
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getUsername() {
        return properties.getProperty(USERNAME_PROPERTY);
    }

    public String getPassword() {
        return properties.getProperty(PASSWORD_PROPERTY);
    }
}
