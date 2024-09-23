package util;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

public class TestUtil {
    public static long Page_Load_Timeout = 40;
    public static long Implicitly_Wait = 30;
    public byte[] takescreenshotFaliure(WebDriver driver) {
        TakesScreenshot take=(TakesScreenshot) driver;
        File SfFile= take.getScreenshotAs(OutputType.FILE);
        File dir=new File("C:\\BridgeLabz\\Quality Kiosk\\Automation_Testing\\GivaTest_Automation\\ScreenShots" + "photo.png");
        try {
            FileHandler.copy(SfFile, dir);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }
}