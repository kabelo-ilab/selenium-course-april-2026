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
public class LoginPOM {
    private static WebDriver driver;
    private static By txtUsername = By.cssSelector("input[placeholder='Username']");
    private static By txtPassword = By.xpath("//input[@placeholder='Password']");
    private static By btnLogin = By.xpath("//button[@type='submit']");
    private static By lblErrorMsg = By.cssSelector(".oxd-text.oxd-text--p.oxd-alert-content-text");

    public LoginPOM(WebDriver theDriver){
        driver = theDriver;
        driver.manage().window().maximize();
    }

    public static void openPage(){
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    public static void enterUsername(String username){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(txtUsername).sendKeys(username);
    }
    public static void enterPassword(String password){
        driver.findElement(txtPassword).sendKeys(password);
    }

    public static void clickLogin(){
        driver.findElement(btnLogin).click();
    }

    public static void adminLogin(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(txtUsername).sendKeys("Admin");
        driver.findElement(txtPassword).sendKeys("admin123");
        driver.findElement(btnLogin).click();
    }

    public static String getErrorMsg(){
        WebElement lblError = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.presenceOfElementLocated(lblErrorMsg));
       return lblError.getText();
    }

}
