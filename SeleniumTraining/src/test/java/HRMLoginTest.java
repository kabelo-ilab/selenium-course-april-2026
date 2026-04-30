import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

/**
 * @author: Kabelo Tlhape
 **/
public class HRMLoginTest {
    WebDriver driver;
    LoginPOM login;
    @BeforeClass
    void setup(){
       driver = new ChromeDriver();
    }

    @Test(testName = "TC1 - Valid Login")
    void testValidLogin(){
        //Arrange
        String expectedURL = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";

        login = new LoginPOM(driver);

        login.openPage();
        login.adminLogin();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //Actual
        String actualURL = driver.getCurrentUrl();
        //Assert
        Assert.assertEquals(actualURL, expectedURL);
    }

    @Test(testName = "TC2 - Invalid Login (Invalid Password)", description = "Test login with invalid password")
    void loginInvalidPassword(){

        String expectedErrorMsg = "Invalid credentials";

        login = new LoginPOM(driver);

        login.openPage();
        login.enterUsername("Admin");
        login.enterPassword("admin12345");
        login.clickLogin();

        String actualErrorMsg = LoginPOM.getErrorMsg();

        Assert.assertEquals(actualErrorMsg, expectedErrorMsg);
    }

    //Test Method without using Page Object Model (POM)
    @Test(testName = "TC3 - Invalid Login (Invalid Username)", description = "Test login with invalid username")
    void loginInvalidUsername(){

        String expectedErrorMsg = "Invalid credentials";
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        WebElement txtUsername = new WebDriverWait(driver,Duration.ofSeconds(5))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='username']")));
        txtUsername.sendKeys("Admin");
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin1234");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        WebElement lblErrorMsg = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".oxd-text.oxd-text--p.oxd-alert-content-text")));

        String actualErrorMsg = lblErrorMsg.getText();

        Assert.assertEquals(actualErrorMsg, expectedErrorMsg);
    }



    //Invalid login

    @AfterClass
    void tearDown(){
        try {
            Thread.sleep(5000);
            driver.quit();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
