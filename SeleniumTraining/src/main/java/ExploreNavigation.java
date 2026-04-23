import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

/**
 * Created by @author Kabelo Tlhape
 * Created on: 4/22/2026
 * ExploreNavigation:
 */
public class ExploreNavigation {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.selenium.dev/");
        String strSeleniumWindow = driver.getWindowHandle();
        //maximize the window
        driver.manage().window().maximize();
        //open new window and visit https://www.ilabquality.com/
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.ilabquality.com/");

        String strILabWindow = driver.getWindowHandle();

        System.out.println("Selenium: " + strSeleniumWindow);
        System.out.println("iLAB: " + strILabWindow);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //switch back to Selenium
        driver.switchTo().window(strSeleniumWindow);

        //open a new tab
        driver.switchTo().newWindow(WindowType.TAB);
        //open a URL using navigate method
        driver.navigate().to("https://www.ilabquality.com/training/");
        driver.navigate().to("https://www.ilabquality.com/get-in-touch/");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.navigate().back();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.quit();

    }
}
