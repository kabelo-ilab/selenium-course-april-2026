import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

/**
 * @author: Kabelo Tlhape
 **/
public class HandleAlerts {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();

        Actions actions = new Actions(driver);

        driver.findElement(By.cssSelector("a[href='/context_menu']")).click();

        WebElement box = driver.findElement(By.cssSelector("#hot-spot"));
        actions.contextClick(box).perform();

        Alert alert = driver.switchTo().alert();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        alert.accept();
    }
}
