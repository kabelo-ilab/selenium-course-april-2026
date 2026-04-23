import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * @author: Kabelo Tlhape
 **/
public class TheExplicitWait {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        //username
        WebElement txtUsername = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='username']")));

        txtUsername.sendKeys("Admin");

        //driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
        //password
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
        //click login
        driver.findElement(By.xpath("//button[@type='submit']")).click();

    }
}
