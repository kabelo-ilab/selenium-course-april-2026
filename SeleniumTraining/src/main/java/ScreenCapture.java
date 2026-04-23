
import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

/**
 * @author: Kabelo Tlhape
 **/
public class ScreenCapture {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        //open Selenium URL at https://www.selenium.dev/
        driver.get("https://www.selenium.dev/");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //Take a screenshot
       File source = ((TakesScreenshot) (driver)).getScreenshotAs(OutputType.FILE);
       File destinationFile = new File("src/main/resources/screenshot.png");
       //move file (source) from memory to physical location (destination)

        try {
            Files.move(source, destinationFile);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        driver.quit();


    }
}
