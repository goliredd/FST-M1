package Project;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class PActivity7 {
    public static void main(String[] args) throws InterruptedException {
        // Setup the Firefox driver(GeckoDriver)
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        WebDriverManager.firefoxdriver().setup();
        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();
        Actions builder = new Actions(driver);
        driver.get("http://alchemy.hguy.co/crm");
        // Login
        driver.findElement(By.name("user_name")).sendKeys("admin");
        driver.findElement(By.name("username_password")).sendKeys("pa$$w0rd");
        driver.findElement(By.id("bigbutton")).click();
        // Navigate to Sales -> Leads
        driver.findElement(By.id("grouptab_0")).click();
        WebElement Leads = driver.findElement(By.cssSelector("ul.navbar-nav li.topnav ul.dropdown-menu li:nth-of-type(5)"));
        Leads.click();
        WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds(20));
        String text = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='moduleTitle']/h2"))).getText();
        Assert.assertEquals(" LEADS", text);
        // Find the Additional information icon at the end of the row of the lead information then Click it
        driver.findElement(By.xpath("//*[@id='adspan_1fefe55c-77e6-e7f6-d8cb-5db0c115c3f9']")).click();
        // Read the popup and print the phone number displayed in it
        WebElement Mobile = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div>span.phone:nth-of-type(1)")));
        System.out.println("phone number: " +Mobile.getText());
        // Close the browser
        driver.quit();
    }
}
