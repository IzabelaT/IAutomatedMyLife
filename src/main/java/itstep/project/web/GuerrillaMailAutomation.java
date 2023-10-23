package itstep.project.web;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GuerrillaMailAutomation {
    private static final String GUERRILLA_URL = "https://www.guerrillamail.com/inbox";
    private static final String AGREE_BUTTON_CLASS_NAME = "fc-button-label";
    private static final String CHANGE_EMIAL_ID = "inbox-id";
    private static final String WRITE_EMAIL_CSS_SELECTOR = "#inbox-id > input:nth-child(1)";
    private static final String MY_EMAIL = "test123";
    private static final String SET_EMAIL_BUTTON_CSS_SELECTOR = ".save";
    private static final String JAVASCRIPT_EXECUTER_SCRIPT = "window.open('about:blank','_blank');";
    public static void performActions(WebDriver driver) throws InterruptedException {
        driver.get(GUERRILLA_URL);
        System.out.println("GuerrillaMailAutomation Opened!");
        WebElement agreeButton = driver.findElement(By.className(AGREE_BUTTON_CLASS_NAME));
        agreeButton.click();
        WebElement changeEmail = driver.findElement(By.id(CHANGE_EMIAL_ID));
        changeEmail.click();
        WebElement writeEmail = driver.findElement(By.cssSelector(WRITE_EMAIL_CSS_SELECTOR));
        writeEmail.sendKeys(MY_EMAIL);
        WebElement setButton = driver.findElement(By.cssSelector(SET_EMAIL_BUTTON_CSS_SELECTOR));
        setButton.click();

        ((JavascriptExecutor) driver).executeScript(JAVASCRIPT_EXECUTER_SCRIPT);

        // Switch to the new tab
        driver.switchTo().window(driver.getWindowHandles().toArray()[4].toString());
        System.out.println("GuerrillaMailAutomation Completed!");
    }
}
