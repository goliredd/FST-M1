package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity3 {
    public static void main(String[] args) throws InterruptedException {
        // Setup the Firefox driver(GeckoDriver)
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        WebDriverManager.firefoxdriver().setup();
        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();
        // Activity1 with XPath expression
        driver.get("https://v1.training-support.net");
        Thread.sleep(2000);
        System.out.println("Title of the page: " + driver.getTitle());
        // Find the "About Us" button and click it
        driver.findElement(By.xpath("//a[@id = 'about-link']")).click();
        System.out.println("Title of the new page: " + driver.getTitle());
        Thread.sleep(2000);
        // Activity2 with XPath expression
        driver.navigate().to("https://v1.training-support.net/selenium/login-form");
        System.out.println("Title of Activity2 page: " +driver.getTitle());
        // Find username and password and send keys then click Log in button
        driver.findElement(By.xpath("//input[@id = 'username']")).sendKeys("admin");
        driver.findElement(By.xpath("//input[@name = 'Password']")).sendKeys("password");
        driver.findElement(By.xpath("//button[contains(@onclick,'signIn()')]")).click();
        Thread.sleep(2000);
        String ConfirmMsg = driver.findElement(By.xpath("//div[@id='action-confirmation']")).getText();
        System.out.println("Confirmation message: " +ConfirmMsg);
        driver.quit();
    }
}