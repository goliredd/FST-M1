package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity21 {
    public static void main(String[] args) throws InterruptedException {
        // Setup the Firefox driver(GeckoDriver)
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        WebDriverManager.firefoxdriver().setup();
        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/tab-opener");
        System.out.println("Title of the page: " + driver.getTitle());
        // Find the button to open a new tab and click it
        driver.findElement(By.id("launcher")).click();
        // Wait for the new tab to open
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        // Print all the handles
        System.out.println("Window handles available so far: " +driver.getWindowHandles());
        // Switch to the newly opened tab
        for(String handle: driver.getWindowHandles()){
            driver.switchTo().window(handle);
        }
        // Wait for the new page to load
        wait.until(ExpectedConditions.elementToBeClickable(By.id("actionButton")));
        // Print it's title and heading
        System.out.println("New window's handle: " +driver.getWindowHandle());
        System.out.println("Title of the new page: " +driver.getTitle());
        String pageHeading = driver.findElement(By.xpath("//div[@class='content']")).getText();
        System.out.println("Page Heading: " +pageHeading);
        // Click the button in the new tab page
        driver.findElement(By.id("actionButton")).click();
        wait.until(ExpectedConditions.numberOfWindowsToBe(3));
        // Print all the handles
        System.out.println("Window handles available so far: " +driver.getWindowHandles());
        // Switch to the newly opened tab
        for(String handle: driver.getWindowHandles()){
            driver.switchTo().window(handle);
        }
        // Wait for the new page to load
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("content")));
        // Print the page title and heading
        System.out.println("Title of new page: " +driver.getTitle());
        String PageHeading1 = driver.findElement(By.className("content")).getText();
        System.out.println("New page Heading: " +PageHeading1);
        // Close the browser
        driver.quit();
    }
}
