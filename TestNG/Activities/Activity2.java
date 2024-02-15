package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class Activity2 {
    WebDriver driver;
    @BeforeClass
    public void BeforeMethod(){
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
        WebDriverManager.firefoxdriver().setup();
        // Create a new instance of the Firefox driver
        driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/target-practice");
    }

    @Test
    public void Test1(){
        String PageTitle = driver.getTitle();
        System.out.println("Print the title of the page: " +PageTitle);
        Assert.assertEquals("Target Practice",  PageTitle);
    }

    @Test
    public void Test2(){
        WebElement blackButton = driver.findElement(By.className("black"));
        Assert.assertFalse(blackButton.isDisplayed());
    }

    @Test (enabled = false)
    public void Test3(){
        System.out.println("This test is skipped");
    }

    @Test
    public void Test4(){
        throw new SkipException("Test case is skipped");
    }

    @AfterClass
    public void AfterMethod(){
        driver.close();
    }
}
