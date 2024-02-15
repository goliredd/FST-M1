package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4 {
    public static void main(String[] args) throws InterruptedException {
        // Setup the Firefox driver(GeckoDriver)
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        WebDriverManager.firefoxdriver().setup();
        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/target-practice");
        Thread.sleep(2000);
        System.out.println("Title of the page: " + driver.getTitle());
        // Finding the 3rd header on the page and print it's text
        String thirdHeaderText = driver.findElement(By.xpath("//h3[@id='third-header']")).getText();
        System.out.println(thirdHeaderText);
        // Finding the 5th header on the page and print it's color
        String fifthHeaderElement = driver.findElement(By.xpath("//h5[@class='ui green header']")).getCssValue("color");
        System.out.println(fifthHeaderElement);
        // Finding the violet button and print all it's classes
        String violetButton = driver.findElement(By.cssSelector(".ui.violet.button")).getAttribute("class");
        System.out.println(violetButton);
        // Finding the grey button and print it's text
        String greyButton = driver.findElement(By.cssSelector(".ui.grey.button")).getText();
        System.out.println(greyButton);
        driver.quit();
    }
}
