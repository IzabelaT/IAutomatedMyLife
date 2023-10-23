package itstep.project.desktop;

import org.openqa.selenium.By;

public class Postman {
    private WiniumDriverManager driverManager;
    private static final String CLOSE_POSTMAN_NAME = "Close";

    public Postman(String applicationPath) {
        if(applicationPath != null && !applicationPath.isEmpty()){
            this.driverManager = new WiniumDriverManager(applicationPath);
        }
        else{
            System.out.println("Postman Application Path can't be Null or Empty");
        }
    }

    public void openPostman() {
        System.out.println("Postman is open to work!");
    }
    public void closePostman() {
        try {
            driverManager.getWiniumDriver().findElement(By.name(CLOSE_POSTMAN_NAME)).click();
            Thread.sleep(2000);

            System.out.println("Calculator is closed!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
