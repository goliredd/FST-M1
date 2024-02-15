package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity1 {
    public static void main(String[] args) throws InterruptedException {
        // Setup the Firefox driver(GeckoDriver)
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        WebDriverManager.firefoxdriver().setup();
        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net");
        Thread.sleep(2000);
        System.out.println("Title of the page: " +driver.getTitle());
        // Find the "About Us" button and click it
        driver.findElement(By.id("about-link")).click();
        System.out.println("Title of the new page: " +driver.getTitle());
        driver.quit();
    }
}
