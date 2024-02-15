package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class Activity13 {
    public static void main(String[] args) throws InterruptedException {
        // Setup the Firefox driver(GeckoDriver)
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        WebDriverManager.firefoxdriver().setup();
        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/tables");
        String Title = driver.getTitle();
        System.out.println("Title of the page: " +Title);
        // Find the number of rows and columns in the first table
        List<WebElement> rows = driver.findElements(By.xpath("//table[contains(@class,'striped')]/tbody/tr"));
        System.out.println("No.of rows: " +rows.size());
        List<WebElement> cols = driver.findElements(By.xpath("//table[contains(@class,'striped')]/tbody/tr[1]/td"));
        System.out.println("No.of columns: " +cols.size());
        // Find and print all the cell values in the third row of the table
        List<WebElement> thirdRow = driver.findElements(By.xpath("//table[contains(@class,'striped')]/tbody/tr[3]/td"));
        System.out.println("Cell values in the third row of the table are: ");
        for(WebElement cell: thirdRow){
            System.out.println(cell.getText());
        }
        // Find and print the cell value at the second row second column
        WebElement secRowSecCol = driver.findElement(By.xpath("//table[contains(@class,'striped')]/tbody/tr[2]/td[2]"));
        System.out.println("Cell value at the second row second column: " +secRowSecCol.getText());
        // Close the browser
        driver.quit();
    }
}
