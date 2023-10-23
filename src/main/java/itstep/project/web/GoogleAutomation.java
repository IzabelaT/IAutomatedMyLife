package itstep.project.web;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleAutomation {
    private static final String GOOGLE_URL = "https://www.google.com/?gws_rd=ssl";
    private static final String AGREE_BUTTON_ID = "W0wltc";
    private static final String JAVASCRIPT_EXECUTER_SCRIPT = "window.open('about:blank','_blank');";
    public static void performActions(WebDriver driver) throws InterruptedException {
        driver.get(GOOGLE_URL);
        System.out.println("GoogleAutomation Opened!");
        WebElement agreeButton = driver.findElement(By.id(AGREE_BUTTON_ID));
        agreeButton.click();

        ((JavascriptExecutor) driver).executeScript(JAVASCRIPT_EXECUTER_SCRIPT);

        // Switch to the new tab
        driver.switchTo().window(driver.getWindowHandles().toArray()[3].toString());
        System.out.println("GoogleAutomation Completed!");
    }
}
