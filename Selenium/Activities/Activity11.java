package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity11 {
    public static void main(String[] args) throws InterruptedException {
        // Setup the Firefox driver(GeckoDriver)
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        WebDriverManager.firefoxdriver().setup();
        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/dynamic-controls");
        System.out.println("Title of the page: " + driver.getTitle());
        // Find the checkbox input element
        WebElement checkbox = driver.findElement(By.name("toggled"));
        System.out.println("Is checkbox is selected: " +checkbox.isSelected());
        // Click the checkbox
        checkbox.click();
        Thread.sleep(1000);
        System.out.println("Is checkbox is selected: " +checkbox.isSelected());
        driver.quit();
    }
}
