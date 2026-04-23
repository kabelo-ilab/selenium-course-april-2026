import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

/**
 * @author: Kabelo Tlhape
 **/
public class HRMLogin {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        //wait for 5 seconds - use implicit wait

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
        //username
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
        //password
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
        //click login
        driver.findElement(By.xpath("//button[@type='submit']")).click();

    }
}
