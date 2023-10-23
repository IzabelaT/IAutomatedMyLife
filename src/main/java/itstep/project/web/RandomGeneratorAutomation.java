package itstep.project.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RandomGeneratorAutomation {
    private static final String AVAST_RANDOM_GENERATOR_PASSWORD_URL = "https://www.avast.com/random-password-generator#pc";
    private static final String OK_BUTTON_XPATH = "//*[@id=\"onetrust-accept-btn-handler\"]";
    private static final String JAVASCRIPT_EXECUTER_SCRIPT = "window.open('about:blank','_blank');";
    public static void performActions(WebDriver driver) throws InterruptedException {
        driver.get(AVAST_RANDOM_GENERATOR_PASSWORD_URL);
        System.out.println("RandomGeneratorAutomation Opened!");
        Thread.sleep(2000);
        WebElement okButton = driver.findElement(By.xpath(OK_BUTTON_XPATH));
        okButton.click();
        System.out.println("RandomGeneratorAutomation Completed!");
    }
}
