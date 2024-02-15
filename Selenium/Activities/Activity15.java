package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity15 {
    public static void main(String[] args) throws InterruptedException {
        // Setup the Firefox driver(GeckoDriver)
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        WebDriverManager.firefoxdriver().setup();
        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/dynamic-attributes");
        System.out.println("Title of the page: " +driver.getTitle());
        // Find the username and password input fields and type in the credentials
        driver.findElement(By.xpath("//input[starts-with(@class,'username-')]")).sendKeys("admin");
        driver.findElement(By.xpath("//input[starts-with(@class,'password-')]")).sendKeys("password");
        driver.findElement(By.cssSelector("button.ui.button:nth-child(4)")).click();
        // Wait for login message to appear and print the login message
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement confirmMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("action-confirmation")));
        System.out.println("Login message: " +confirmMsg.getText());
        // Close the browser
        driver.quit();
    }
}
