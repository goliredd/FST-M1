package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class Activity14 {
    public static void main(String[] args) throws InterruptedException {
        // Setup the Firefox driver(GeckoDriver)
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        WebDriverManager.firefoxdriver().setup();
        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/tables");
        String Title = driver.getTitle();
        System.out.println("Title of the page: " + Title);
        // Find the number of rows and columns in the second table
        List<WebElement> rows = driver.findElements(By.xpath("//table[contains(@class,'sortable')]/tbody/tr"));
        System.out.println("No.of rows: " +rows.size());
        List<WebElement> cols = driver.findElements(By.xpath("//table[contains(@class,'sortable')]/thead/tr/th"));
        System.out.println("No.of columns: " +cols.size());
        // Find and print the cell value at the second row second column
        WebElement secRowSecCol1 = driver.findElement(By.xpath("//table[contains(@class,'sortable')]/tbody/tr[2]/td[2]"));
        System.out.println("Cell value at the second row second column: " +secRowSecCol1.getText());
        // Click the header of the first column to sort by name
        driver.findElement(By.xpath("//table[contains(@class,'sortable')]/thead/tr/th[1]")).click();
        // print the cell value at the second row second column
        WebElement secRowSecCol2 = driver.findElement(By.xpath("//table[contains(@class,'sortable')]/tbody/tr[2]/td[2]"));
        System.out.println("Cell value at the second row second column: " +secRowSecCol2.getText());
        // Print the cell values of the table footer
        List<WebElement> footer = driver.findElements(By.xpath("//table[contains(@class,'sortable')]/tfoot/tr/th"));
        System.out.println("Cell values of the table footer are: ");
        for(WebElement value : footer){
            System.out.println(value.getText());

        }
        // Close the browser
        driver.quit();
    }
}
