package Project;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class PActivity8 {
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
        // Navigate to Sales -> Accounts page
        driver.findElement(By.id("grouptab_0")).click();
        WebElement Accounts = driver.findElement(By.cssSelector("ul.navbar-nav li.topnav ul.dropdown-menu li:nth-of-type(2)"));
        Accounts.click();
        WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds(20));
        // Assert Accounts page
        String text = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='moduleTitle']/h2"))).getText();
        Assert.assertEquals(" ACCOUNTS", text);
        // Find the table on the page and print the names of the first 5 odd-numbered rows of the table to the console.
        List<WebElement> firstRow = driver.findElements(By.xpath("//table[contains(@class,'table-responsive')]/tbody/tr[1]/td"));
        System.out.println("First row: ");
        for(WebElement cell: firstRow){
            System.out.println(cell.getText());
        }
        List<WebElement> thirdRow = driver.findElements(By.xpath("//table[contains(@class,'table-responsive')]/tbody/tr[3]/td"));
        System.out.println("Third row: ");
        for(WebElement cell: thirdRow){
            System.out.println(cell.getText());
        }
        List<WebElement> fifthRow = driver.findElements(By.xpath("//table[contains(@class,'table-responsive')]/tbody/tr[5]/td"));
        System.out.println("Fifth row: ");
        for(WebElement cell: fifthRow){
            System.out.println(cell.getText());
        }
        List<WebElement> seventhRow = driver.findElements(By.xpath("//table[contains(@class,'table-responsive')]/tbody/tr[7]/td"));
        System.out.println("Seventh row: ");
        for(WebElement cell: seventhRow){
            System.out.println(cell.getText());
        }
        List<WebElement> ninthRow = driver.findElements(By.xpath("//table[contains(@class,'table-responsive')]/tbody/tr[9]/td"));
        System.out.println("Ninth row: ");
        for(WebElement cell: ninthRow){
            System.out.println(cell.getText());
        }
        // Close the browser
         driver.quit();
    }
}
