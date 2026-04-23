package KeywordDrivenTests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
@author: Kabelo Tlhape
**/
public class HRMLogin {

    Keywords keywords;

    @BeforeClass
    void setup(){
        keywords = new Keywords();
    }

    @Test
    void testInvalidLogin(){
        String expectedErrorMsg = "Invalid credentials";

        keywords.openBrowser("edge");
        keywords.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        keywords.enterText(By.xpath("//input[@name='username']"),"Admin");
        keywords.enterText(By.xpath("//input[@placeholder='Password']"),"admin11");
        keywords.click(By.xpath("//button[@type='submit']"));

       boolean expectedResults = keywords.verifyText(By.cssSelector(".oxd-text.oxd-text--p.oxd-alert-content-text"),expectedErrorMsg);

        Assert.assertTrue(expectedResults);

    }
}
