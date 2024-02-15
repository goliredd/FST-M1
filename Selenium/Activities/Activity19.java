package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity19 {
    public static void main(String[] args) throws InterruptedException {
        // Setup the Firefox driver(GeckoDriver)
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        WebDriverManager.firefoxdriver().setup();
        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/javascript-alerts");
        System.out.println("Title of the page: " + driver.getTitle());
        // Find the button to open a CONFIRMATION alert and click it
        driver.findElement(By.id("confirm")).click();
        // Wait for the alert to display
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        // Switch the focus from the main window to the Alert box and print the text in it
        Alert alert = driver.switchTo().alert();
        System.out.println("Alert text: " +alert.getText());
        Thread.sleep(1000);
        // Close the alert with Ok
        alert.accept();
        // close the alert with Cancel
        // alert.dismiss();
        // Close the browser
        driver.quit();
    }
}
