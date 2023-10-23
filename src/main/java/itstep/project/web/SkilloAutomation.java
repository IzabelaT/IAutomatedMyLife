package itstep.project.web;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class SkilloAutomation {
    private static final String SKILLO_URL =
            "https://www.skillo-bg.com/kurs-automation-qa.html?gclid=EAIaIQobChMImqSOnNHngQMVHopoCR25UA93EAAYASAAEgJQofD_BwE";
    private static final String JAVASCRIPT_EXECUTER_SCRIPT = "window.open('about:blank','_blank');";
    public static void performActions(WebDriver driver) throws InterruptedException {
        driver.get(SKILLO_URL);
        System.out.println("SkilloAutomation Opened!");

        ((JavascriptExecutor) driver).executeScript(JAVASCRIPT_EXECUTER_SCRIPT);

        // Switch to the new tab
        driver.switchTo().window(driver.getWindowHandles().toArray()[5].toString());
        System.out.println("SkilloAutomation Completed!");
    }
}
