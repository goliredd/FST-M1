package Project;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;


public class PActivity1 {
    public static void main(String[] args) throws InterruptedException {
        // Setup the Firefox driver(GeckoDriver)
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        WebDriverManager.firefoxdriver().setup();
        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();
        driver.get("http://alchemy.hguy.co/crm");
        // Get the title of the website
        String PageTitle = driver.getTitle();
        System.out.println("Title of the page: " + PageTitle);
        // Make sure title matches “SuiteCRM” exactly.
        Assert.assertEquals("SuiteCRM",  PageTitle);
        // close the browser
        driver.quit();
    }
}
