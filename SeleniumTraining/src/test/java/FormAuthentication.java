import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * @author: Kabelo Tlhape
 **/
public class FormAuthentication {

    WebDriver driver;
    ExtentReports report;
    ExtentSparkReporter rptSpark;
    String reportURI = "src/test/resources/Form Auth.html";

    @BeforeClass
    void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        report = new ExtentReports();
        rptSpark = new ExtentSparkReporter(reportURI);

        rptSpark.config().setReportName("Test Form Authentication");

        report.attachReporter(rptSpark);
    }

    @Test(testName = "TC1 - Landing Page", description = "Open landing page", priority = 1)
    void openLandingPage(){
        String expectedText = "Welcome to the-internet";
        driver.get("https://the-internet.herokuapp.com/");

        WebElement lblHeading = driver.findElement(By.xpath("//h1[@class='heading']"));

        String actualText = lblHeading.getText();

        Assert.assertEquals(actualText, expectedText);

    }

    @Test(testName = "TC2 - Login Page", description = "Open Login Page", priority = 2)
    void openLogin(){
        String expectedURL = "https://the-internet.herokuapp.com/login";

        driver.findElement(By.cssSelector("a[href='/login']")).click();

        String actualURL = driver.getCurrentUrl();

        Assert.assertEquals(actualURL, expectedURL);
    }

    @Test(testName = "TC3 - Verify Login", description = "Verify Login", priority = 3)
    void verifyLogin(){
        driver.findElement(By.cssSelector("#username")).sendKeys("tomsmith");
        driver.findElement(By.cssSelector("#password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.cssSelector("button[type=submit]")).click();

        WebElement btnLogin = driver.findElement(By.cssSelector("a[href='/logout']"));

        Assert.assertTrue(btnLogin.isDisplayed(), "Button 'Logout' should be displayed");
    }

    @AfterMethod
    void createReport(ITestResult results){
        ExtentTest myTest = report.createTest(results.getMethod().getDescription());
        Status status = Status.FAIL;
        //Take a screenshot

        String screenshot = ((TakesScreenshot) (driver)).getScreenshotAs(OutputType.BASE64);

        if (results.getStatus() == ITestResult.SUCCESS){
            status = Status.PASS;
        }
        myTest.log(status,"Text");
        //Attach screenshot to the report
        myTest.addScreenCaptureFromBase64String(screenshot);
    }

    @AfterClass(description = "Close all resources")
    void finishTest(){
        report.flush();
        try{
            Desktop.getDesktop().browse(new File(reportURI).toURI());
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
        driver.quit();
    }
}
