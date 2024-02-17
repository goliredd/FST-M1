package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;


public class Activity6 {
    WebDriver driver;
    @BeforeClass
    public void BeforeMethod(){
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
        WebDriverManager.firefoxdriver().setup();
        // Create a new instance of the Firefox driver
        driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/login-form");
    }

    @Test
    @Parameters({"username", "password"})
    public void login(String username, String password){
        // Find username and password text boxes and Log in button
        WebElement username1 =  driver.findElement(By.id("username"));
        WebElement password1 =  driver.findElement(By.name("Password"));
        WebElement loginButton = driver.findElement(By.xpath("//button[text()='Log in']"));
        // Use sendKeys() with the variable names as input. Then click() the login button
        username1.sendKeys(username);
        password1.sendKeys(password);
        loginButton.click();
        // Assert the login message
        String message = driver.findElement(By.id("action-confirmation")).getText();
        Assert.assertEquals("Welcome Back, admin", message);
    }

    @AfterClass
    public void AfterMethod(){
        driver.close();
    }
}
