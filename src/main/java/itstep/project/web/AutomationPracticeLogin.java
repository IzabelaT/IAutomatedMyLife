package itstep.project.web;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AutomationPracticeLogin {
    private static final String AUTO_PRACTICE_URL = "http://www.automationpractice.pl/index.php?controller=authentication&back=my-account";
    private static final String PROPERTIES_PATH = "src/main/resources/autopractice.properties";
    private static final String USER_NAME_ID = "email";
    private static final String PASSWORD_ID = "passwd";
    private static final String LOGIN_BUTTON_ID = "SubmitLogin";
    private static final String JAVASCRIPT_EXECUTER_SCRIPT = "window.open('about:blank','_blank');";
    public static void performLogin(WebDriver driver) throws InterruptedException {
        System.out.println("AutomationPracticeLogin Opened!");

        CredentialReader autoPractice = new CredentialReader(PROPERTIES_PATH);
        driver.get(AUTO_PRACTICE_URL);
        WebElement usernameField = driver.findElement(By.id(USER_NAME_ID));
        WebElement passwordField = driver.findElement(By.id(PASSWORD_ID));
        WebElement loginButton = driver.findElement(By.id(LOGIN_BUTTON_ID));

        usernameField.sendKeys(autoPractice.getUsername());
        passwordField.sendKeys(autoPractice.getPassword());

        loginButton.click();

        try {
            Thread.sleep(5000); // 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (driver.getCurrentUrl().equals(AUTO_PRACTICE_URL)) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Login failed!");
        }
        System.out.println("AutomationPracticeLogin Completed!");
        // Open a new tab using JavaScript
        ((JavascriptExecutor) driver).executeScript(JAVASCRIPT_EXECUTER_SCRIPT);

        // Switch to the new tab
        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
    }
}
