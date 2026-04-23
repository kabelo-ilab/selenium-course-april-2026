package KeywordDrivenTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * @author: Kabelo Tlhape
 **/
public class Keywords {
    WebDriver driver;

    public void openBrowser(String browser){

        if (browser.equals("chrome")){
            driver = new ChromeDriver();
        } else if (browser.equals("edge")) {
            driver = new EdgeDriver();
        }else{
            driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
    }

    public void navigate(String url){
        driver.get(url);
    }

    public void enterText(By locator, String text){
        WebElement txtUsername = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.presenceOfElementLocated(locator));
        txtUsername.sendKeys(text);
    }

    public void click(By locator){
        driver.findElement(locator).click();
    }

    public boolean verifyText(By locator, String expectedText){
        WebElement lblErrorMsg = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.presenceOfElementLocated(locator));
        String actualText = lblErrorMsg.getText();
        return actualText.equals(expectedText);
    }

}
