package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity16 {
    public static void main(String[] args) throws InterruptedException {
        // Setup the Firefox driver(GeckoDriver)
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        WebDriverManager.firefoxdriver().setup();
        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/dynamic-attributes");
        System.out.println("Title of the page: " + driver.getTitle());
        // Find the input fields of the Sign-Up form and fill the details
        driver.findElement(By.cssSelector("input[class$='-username']")).sendKeys("John");
        driver.findElement(By.cssSelector("input[class$='-password']")).sendKeys("password");
        driver.findElement(By.xpath("//label[text()='Confirm Password']/following::input[1]")).sendKeys("password");
        driver.findElement(By.cssSelector("input[class^='email-']")).sendKeys("john.j1@gmail.com");
        driver.findElement(By.cssSelector("button.ui.button:nth-child(6)")).click();
        // Wait for success message to appear and print it
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String successMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("action-confirmation"))).getText();
        System.out.println("Success message: " +successMsg);
        // Close the browser
        driver.quit();
    }
}
