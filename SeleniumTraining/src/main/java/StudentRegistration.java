import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

/**
 * @author: Kabelo Tlhape
 **/
public class StudentRegistration {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        //open url
        driver.get("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");
        driver.manage().window().maximize();
        //find elements
        //firstname
        WebElement txtFirstname = driver.findElement(By.cssSelector("#name"));
        txtFirstname.sendKeys("Kabelo");
        //email
        driver.findElement(By.xpath("//input[@id=\"email\"]")).sendKeys("kabelo@email.com");
        //gender-male
        WebElement rdoMale = driver.findElement(By.cssSelector("#gender"));
        //gender-female
//        WebElement rdoFemale = driver.findElement(By.xpath("/html/body/main/div/div/div[2]/form/div[3]/div/div/div[2]/input"));
//        rdoFemale.click();

        WebElement rdoFemale = driver.findElement(with(By.tagName("input")).toRightOf(rdoMale));
        rdoFemale.click();
        //dob
        WebElement dtpDateOfBirth = driver.findElement(By.cssSelector("#dob"));
        dtpDateOfBirth.sendKeys("11-04-2026");

    }
}
