package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import org.testng.Assert;


public class Activity1{
    WebDriver driver;
    @BeforeClass
    public void BeforeMethod(){
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
        WebDriverManager.firefoxdriver().setup();
        // Create a new instance of the Firefox driver
        driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net");
    }

    @Test
    public void Test1(){
        String PageTitle = driver.getTitle();
        System.out.println("Print the title of the page: " +PageTitle);
        Assert.assertEquals("Training Support",  PageTitle);
        WebElement button = driver.findElement(By.id("about-link"));
        button.click();
        String NewPageTitle = driver.getTitle();
        System.out.println("Print the title of new page: " +NewPageTitle);
        Assert.assertEquals("About Training Support", NewPageTitle);
    }

    @AfterClass
    public void AfterMethod(){
        driver.close();
    }
}
