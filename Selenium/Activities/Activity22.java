package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity22 {
    public static void main(String[] args) throws InterruptedException {
        // Setup the Firefox driver(GeckoDriver)
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        WebDriverManager.firefoxdriver().setup();
        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();
        Actions builder = new Actions(driver);
        driver.get("https://v1.training-support.net/selenium/popups");
        System.out.println("Title of the page: " +driver.getTitle());
        // Find the Sign-in button and hover over it
        WebElement button = driver.findElement(By.className("orange"));
        builder.moveToElement(button).build().perform();
        // Print the tooltip message
        String toolTip = button.getAttribute("data-tooltip");
        System.out.println("Tooltip message: " +toolTip);
        // Click the button to open the Sign-in form
        button.click();
        // Enter the credentials
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.name("Password")).sendKeys("password");
        driver.findElement(By.xpath("//button[text()='Log in']")).click();
        Thread.sleep(2000);
        String message = driver.findElement(By.id("action-confirmation")).getText();
        System.out.println("Login message: " +message);
        // Close the browser
        driver.quit();
    }
}
