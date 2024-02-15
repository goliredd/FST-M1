package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class Activity5 {
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
        // Perform left click and print value of side in the front
        builder.click().pause(1000).build().perform();
        String getText = driver.findElement(By.className("active")).getText();
        System.out.println(getText);
        // Perform Double click to show a random side and print the number
        builder.doubleClick().pause(1000).build().perform();
        String randomSideText = driver.findElement(By.className("active")).getText();
        System.out.println(randomSideText);
        // Perform Right click and print the value shown on the front of the cube
        builder.contextClick().pause(1000).build().perform();
        String frontSideText = driver.findElement(By.className("active")).getText();
        System.out.println(frontSideText);
        // Close the browser
        driver.quit();
    }
}
