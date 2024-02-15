package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity9 {
    public static void main(String[] args) throws InterruptedException {
        // Setup the Firefox driver(GeckoDriver)
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        WebDriverManager.firefoxdriver().setup();
        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/ajax");
        System.out.println("Title of the page: " + driver.getTitle());
        // Find and click the "Change content" button on the page
        driver.findElement(By.className("violet")).click();
        // Wait for the text to say "HELLO!"
        WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds(20));
        String text = wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("h1"))).getText();
        System.out.println("Message that appears on the page: " +text);
        // Wait for the text to change to contain "I'm late!"
        String h3text = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[contains(text(),'late')]"))).getText();
        System.out.println("The new message on the page: " +h3text);
        driver.quit();
    }
}
