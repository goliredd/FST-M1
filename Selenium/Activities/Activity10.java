package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity10 {
    public static void main(String[] args) throws InterruptedException {
        // Setup the Firefox driver(GeckoDriver)
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        WebDriverManager.firefoxdriver().setup();
        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/dynamic-controls");
        System.out.println("Title of the page: " + driver.getTitle());
        // Find the checkbox input element
        WebElement dynamicCheckbox = driver.findElement(By.id("dynamicCheckbox"));
        System.out.println("Is checkbox visible on the page: " +dynamicCheckbox.isDisplayed());
        Thread.sleep(1000);
        // Click the "Remove Checkbox" button
        driver.findElement(By.id("toggleCheckbox")).click();
        System.out.println("Is checkbox visible on the page: " +dynamicCheckbox.isDisplayed());
        driver.quit();
    }
}
