package itstep.project.desktop;

import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class WiniumDriverManager {

    private  WiniumDriver driver;
    private static final String DEFAULT_WINIUM_URL = "http://localhost:9999";

    public WiniumDriverManager(String path) {
        if (driver == null) {
            DesktopOptions options = new DesktopOptions();
            options.setApplicationPath(path);
            driver = new WiniumDriver(getWiniumUrl(), options);
        }
    }

    public WiniumDriver getWiniumDriver() {
        return driver;
    }

    public void closeWiniumDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public URL getWiniumUrl() {
        try {
            return new URL(DEFAULT_WINIUM_URL);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
