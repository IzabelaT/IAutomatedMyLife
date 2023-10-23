package itstep.project;
import itstep.project.desktop.Calculator;
import itstep.project.desktop.Notepad;
import itstep.project.desktop.Postman;
import itstep.project.web.*;
import org.jetbrains.annotations.Nullable;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;


public class Main {
    private static final String WINIUM_DRIVER_PATH = "C:\\Users\\AllBlacks\\IdeaProjects\\IAutomatedMyLife\\src\\main\\resources\\Winium.Desktop.Driver\\Winium.Desktop.Driver.exe";
    private static final String CALC_PATH = "C:\\Windows\\System32\\calc.exe";
    private static final String NOTEPAD_PATH = "C:\\ProgramData\\Microsoft\\Windows\\Start Menu\\Programs\\Notepad++.lnk";
    private static final String POSTMAN_PATH = "C:\\Users\\AllBlacks\\Desktop\\Postman.lnk";
    private static final String WEB_DRIVER_GECKO = "webdriver.gecko.driver";
    private static final String WEB_DRIVER_GECKO_PATH = "C:\\Users\\AllBlacks\\IdeaProjects\\IAutomatedMyLife\\.idea\\driver\\geckodriver.exe";

    public static void main(String[] args) throws InterruptedException {
        Process winiumDriverProcess = null;
        try {
            // Start Winium Desktop Driver
            System.out.println("Desktop Automation Started!");
            winiumDriverProcess = startWiniumDriver();

            Calculator calculator = new Calculator(CALC_PATH);
            calculator.openCalculator();

            Notepad note = new Notepad(NOTEPAD_PATH);
            note.openNotepad();

            Postman post = new Postman(POSTMAN_PATH);
            post.openPostman();

        } finally {
            // Make sure to close the Winium Desktop Driver process
            if (winiumDriverProcess != null) {
                System.out.println("The Process is Destroyed");
                winiumDriverProcess.destroy();
            }
        }
        System.out.println("Desktop Automation Completed!");
        Thread.sleep(5000);



        System.out.println("Web Automation Started!");

        System.setProperty(WEB_DRIVER_GECKO, WEB_DRIVER_GECKO_PATH);


        WebDriver driver = new FirefoxDriver();

        AutomationPracticeLogin.performLogin(driver);

        Bitrix24Login.performActions(driver);

        GoogleAutomation.performActions(driver);

        GuerrillaMailAutomation.performActions(driver);

        SkilloAutomation.performActions(driver);

        RandomGeneratorAutomation.performActions(driver);

        System.out.println("Web Automation Completed!");



    }

    private static @Nullable Process startWiniumDriver() {

        try {
            System.out.println("Start Winium Driver");
            ProcessBuilder processBuilder = new ProcessBuilder(WINIUM_DRIVER_PATH);
            processBuilder.start();
            System.out.println("Process is Started!");
            return processBuilder.start();
        } catch (IOException e) {
            System.out.println("Process Error!");
            e.printStackTrace();
            return null;
        }
    }
}
