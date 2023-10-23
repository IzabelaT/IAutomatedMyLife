package itstep.project.web;

import org.openqa.selenium.*;

public class Bitrix24Login {

    private static final String BITRIX24_URL = "https://www.bitrix24.net/";
    private static final String PROPERTIES_PATH = "src/main/resources/bitrix24.properties";
    private static final String USER_INPUT_ID = "login";
    private static final String FIRST_BUTTON_NEXT_CSS_SELECTOR = "button.ui-btn:nth-child(1)";
    private static final String SECOND_BUTTON_NEXT_CSS_SELECTOR = "button.ui-btn:nth-child(2)";
    private static final String PASSWORD_INPUT_CSS_SELECTOR ="#password";
    private static final String OPEN_BUTTON_CSS_SELECTOR = "a.ui-btn";
    private static final String JAVASCRIPT_EXECUTER_SCRIPT = "window.open('about:blank','_blank');";
    public static void performActions(WebDriver driver) throws InterruptedException {

        driver.get(BITRIX24_URL);

        CredentialReader bitrix24 = new CredentialReader(PROPERTIES_PATH);

        WebElement usernameInput = driver.findElement(By.id(USER_INPUT_ID));
        System.out.println("Bitrix24Login Opened!");


        usernameInput.sendKeys(bitrix24.getUsername());
        Thread.sleep(4000);
        WebElement nextButton1 = driver.findElement(By.cssSelector(FIRST_BUTTON_NEXT_CSS_SELECTOR));
        nextButton1.sendKeys(Keys.ENTER);
        Thread.sleep(4000);
        WebElement passwordInput = driver.findElement(By.cssSelector(PASSWORD_INPUT_CSS_SELECTOR));
        passwordInput.sendKeys(bitrix24.getPassword());
        WebElement nextButton2 = driver.findElement(By.cssSelector(SECOND_BUTTON_NEXT_CSS_SELECTOR));
        nextButton2.sendKeys(Keys.ENTER);
        Thread.sleep(4000);
        WebElement openButton = driver.findElement(By.cssSelector(OPEN_BUTTON_CSS_SELECTOR));
        openButton.click();

        System.out.println("Bitrix24Login Completed!");

        ((JavascriptExecutor) driver).executeScript(JAVASCRIPT_EXECUTER_SCRIPT);

        // Switch to the new tab
        driver.switchTo().window(driver.getWindowHandles().toArray()[2].toString());
    }
}
