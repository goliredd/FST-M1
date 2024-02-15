package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Activity17 {
    public static void main(String[] args) throws InterruptedException {
        // Setup the Firefox driver(GeckoDriver)
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        WebDriverManager.firefoxdriver().setup();
        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/selects");
        System.out.println("Title of the page: " + driver.getTitle());
        // Store the select and make a new select object
        WebElement dropdown = driver.findElement(By.tagName("select"));
        Select select = new Select(dropdown);
        // Select the second option using the visible text
        select.selectByVisibleText("Option 2");
        System.out.println("Second option: " +select.getFirstSelectedOption().getText());
        // Select the third option using the index
        select.selectByIndex(3);
        System.out.println("Third option: " +select.getFirstSelectedOption().getText());
        // Select the fourth option using the value
        select.selectByValue("4");
        System.out.println("Fourth option: " +select.getFirstSelectedOption().getText());
        // Get all the options and print them
        List<WebElement> options = select.getOptions();
        System.out.println("All options: ");
        for(WebElement option : options){
            System.out.println(option.getText());
        }
        // Close the browser
        driver.quit();
    }
}
