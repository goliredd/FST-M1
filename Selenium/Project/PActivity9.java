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

public class PActivity9 {
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
        // Find the table on the page and print the first 10 values in the Name column and the User column of the table to the console
        List<WebElement> nameColumn = driver.findElements(By.xpath("//table[contains(@class,'table-responsive')]/tbody/tr/td[3]"));
        System.out.println("Name Column values: ");
        int counter = 1;
        for (WebElement cell: nameColumn){
            System.out.println(cell.getText());
            counter+=1;
            if (counter==11){
                break;
            }
        }
        int counter1 = 1;
        List<WebElement> userColumn = driver.findElements(By.xpath("//table[contains(@class,'table-responsive')]/tbody/tr/td[8]"));
        System.out.println("User Column values: ");
        for (WebElement cell: userColumn){
            System.out.println(cell.getText());
            counter1+=1;
            if (counter1==11){
                break;
            }
        }
        // Close the browser
        driver.quit();
    }
}
