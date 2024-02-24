package Project;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class PActivity5 {
    public static void main(String[] args) throws InterruptedException {
        // Setup the Firefox driver(GeckoDriver)
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        WebDriverManager.firefoxdriver().setup();
        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();
        driver.get("http://alchemy.hguy.co/crm");
        // login using the credentials
        driver.findElement(By.name("user_name")).sendKeys("admin");
        driver.findElement(By.name("username_password")).sendKeys("pa$$w0rd");
        driver.findElement(By.id("bigbutton")).click();
        String HomePage = driver.findElement(By.id("tab0")).getAttribute("ondblclick");
        // Assertion
        Assert.assertEquals("renameTab(0)",  HomePage);
        // Get the color of the navigation menu and print it to the console.
        String NavMenuColor = driver.findElement(By.id("toolbar")).getCssValue("color");
        System.out.println("color of the navigation menu: " +NavMenuColor);
        // Close the browser
        driver.quit();
    }
}
