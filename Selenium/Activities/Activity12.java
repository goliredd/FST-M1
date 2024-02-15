package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebElement;

public class Activity12 {
    public static void main(String[] args) throws InterruptedException {
        // Setup the Firefox driver(GeckoDriver)
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        WebDriverManager.firefoxdriver().setup();
        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();
        // Open a new browser and get the title of page
        driver.get("https://v1.training-support.net/selenium/dynamic-controls");
        System.out.println("Title of the page: " + driver.getTitle());
        // Find the text field and check if enabled
        WebElement textField = driver.findElement(By.id("input-text"));
        System.out.println("Is text field enabled: " +textField.isEnabled());
        // Click the "Enable Input" button
        Thread.sleep(2000);
        driver.findElement(By.id("toggleInput")).click();
        // Check if the text field is enabled
        System.out.println("Is text field enabled: " +textField.isEnabled());
        driver.quit();
    }
}
