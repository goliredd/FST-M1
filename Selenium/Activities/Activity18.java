package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Activity18 {
    public static void main(String[] args) throws InterruptedException {
        // Setup the Firefox driver(GeckoDriver)
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        WebDriverManager.firefoxdriver().setup();
        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/selects");
        System.out.println("Title of the page: " + driver.getTitle());
        // Store the select and make a new select object
        WebElement dropdown = driver.findElement(By.id("multi-select"));
        Select select = new Select(dropdown);
        // Select the "JavaScript" option using the visible text
        select.selectByVisibleText("Javascript");
        // Select the 4th, 5th and 6th options using the index
        select.selectByIndex(3);
        select.selectByIndex(4);
        select.selectByIndex(5);
        // Select the "NodeJS" option using the value
        select.selectByValue("node");
        // Print all the selected options
        List<WebElement> allSelected = select.getAllSelectedOptions();
        System.out.println("So far selected options: ");
        for(WebElement option: allSelected){
            System.out.println(option.getText());
        }
        // Deselect the 5th option using index
        select.deselectByIndex(4);
        // Print all the selected options
        allSelected = select.getAllSelectedOptions();
        System.out.println("Final selected options: ");
        for(WebElement option: allSelected){
            System.out.println(option.getText());
        }
        // Close the browser
        driver.quit();
    }
}
