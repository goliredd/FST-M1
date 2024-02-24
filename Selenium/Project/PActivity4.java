package Project;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.AssertJUnit;

public class PActivity4 {
    public static void main(String[] args) throws InterruptedException {
        // Setup the Firefox driver(GeckoDriver)
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        WebDriverManager.firefoxdriver().setup();
        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();
        driver.get("http://alchemy.hguy.co/crm");
        // Find and select the username and password fields and enter the credentials
        driver.findElement(By.name("user_name")).sendKeys("admin");
        driver.findElement(By.name("username_password")).sendKeys("pa$$w0rd");
        // Click login
        driver.findElement(By.id("bigbutton")).click();
        String HomePage = driver.findElement(By.id("tab0")).getAttribute("ondblclick");
        // Verify that the homepage has opened
        Assert.assertEquals("renameTab(0)",  HomePage);
        // Close the browser
        driver.quit();
    }
}
