package Data_Driven_Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

/**
 * @author: Kabelo Tlhape
 **/
public class HRMLogin {
    WebDriver driver;

    @BeforeClass
    void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    //Get data from the data provider method
    @Test(dataProvider = "invalidCredentials")
    void invalidLogin(String username, String password){
        String expectedErrorMsg = "Invalid credentials";
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        WebElement txtUsername = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='username']")));
        txtUsername.sendKeys(username);
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(password);
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        WebElement lblErrorMsg = new WebDriverWait(driver, Duration.ofSeconds(8))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".oxd-text.oxd-text--p.oxd-alert-content-text")));

        String actualErrorMsg = lblErrorMsg.getText();

        Assert.assertEquals(actualErrorMsg, expectedErrorMsg);
    }

    //create data for the test method
    @DataProvider(name = "invalidCredentials")
    public Object[][] invalidLoginData(){
        return new Object[][]{
                {"Admin", "password"},
                {"MyAdmin", "admin123"},
                {"MyAdmin", "Pass123"}
        };
    }
}
