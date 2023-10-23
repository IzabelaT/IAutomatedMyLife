package itstep.project.desktop;

import org.openqa.selenium.By;

public class Notepad {
    private WiniumDriverManager driverManager;
    private static final String OUTPUT_CLASS_NAME = "Notepad++";
    private static final String OUTPUT_GET_ATTRIBUTE = "ClassName";
    private static final String CLOSE_NOTEPAD_NAME = "Close";
    public Notepad(String applicationPath) {
        if(applicationPath != null && !applicationPath.isEmpty()){
            this.driverManager = new WiniumDriverManager(applicationPath);
        }
        else{
            System.out.println("Notepad Application Path can't be Null or Empty");
        }
    }
    public void openNotepad() {

            String output = driverManager.getWiniumDriver().findElement(By.className(OUTPUT_CLASS_NAME)).getAttribute(OUTPUT_GET_ATTRIBUTE);

            System.out.println(output + " is open to work!");

    }
    public void closeNotepad() {
        try {
            driverManager.getWiniumDriver().findElement(By.name(CLOSE_NOTEPAD_NAME)).click();
            Thread.sleep(2000);

            System.out.println("Notepad++ is closed!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
