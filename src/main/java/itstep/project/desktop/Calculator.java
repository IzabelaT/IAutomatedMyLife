package itstep.project.desktop;

import org.openqa.selenium.By;

public class Calculator {
    private WiniumDriverManager driverManager;
    private static final String OUTPUT_ID_ELEMENT = "AppName";
    private static final String OUTPUT_ATTRIBUTE = "Name";
    private static final String CLOSE_NAME_ELEMENT = "Close";


    public Calculator(String applicationPath) {
        if(applicationPath != null && !applicationPath.isEmpty()){
            this.driverManager = new WiniumDriverManager(applicationPath);
        }
        else{
            System.out.println("Calculator Application Path can't be Null or Empty");
        }
    }

    public void openCalculator() {
            String output = driverManager.getWiniumDriver().findElement(By.id(OUTPUT_ID_ELEMENT)).getAttribute(OUTPUT_ATTRIBUTE);
            System.out.println(output + " is open to work!");
    }
    public void closeCalculator() {
        try {
            driverManager.getWiniumDriver().findElement(By.name(CLOSE_NAME_ELEMENT)).click();
            Thread.sleep(2000);

            System.out.println("Calculator is closed!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
