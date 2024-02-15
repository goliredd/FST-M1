package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class Activity6 {
    public static void main(String[] args) throws InterruptedException {
        // Setup the Firefox driver(GeckoDriver)
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        WebDriverManager.firefoxdriver().setup();
        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();
        // Initialize Actions object
        Actions builder = new Actions(driver);
        driver.get("https://v1.training-support.net/selenium/input-events");
        Thread.sleep(2000);
        System.out.println("Title of the page: " + driver.getTitle());
        // Press the key of first letter of your name in caps
        builder.sendKeys("A").pause(1000).build().perform();
        // Press CTRL+a and the CTRL+c to copy all the text on the page
        builder.keyDown(Keys.CONTROL).sendKeys("a").sendKeys("c").keyUp(Keys.CONTROL).build().perform();
        // Close the browser
        driver.quit();
    }
}
