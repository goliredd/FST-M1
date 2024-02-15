package Activities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
public class Activity7 {
    public static void main(String[] args) throws InterruptedException {
        // Setup the Firefox driver(GeckoDriver)
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        WebDriverManager.firefoxdriver().setup();
        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();
        // Initialize Actions object
        Actions builder = new Actions(driver);
        driver.get("https://v1.training-support.net/selenium/drag-drop");
        Thread.sleep(2000);
        System.out.println("Title of the page: " + driver.getTitle());
        // Find the ball and simulate a click and drag to move it into "Dropzone 1"
        WebElement ball = driver.findElement(By.id("draggable"));
        WebElement droppable = driver.findElement(By.id("droppable"));
        builder.clickAndHold(ball).moveToElement(droppable).pause(1000).release().build().perform();
        String dropped = driver.findElement(By.cssSelector("div#droppable>p")).getText();
        System.out.println("Is Ball dropped in Dropzone 1: " +dropped);
        WebElement dropzone2 = driver.findElement(By.id("dropzone2"));
        // Move the ball into "Dropzone 2"
        builder.clickAndHold(ball).moveToElement(dropzone2).pause(1000).release().build().perform();
        String dropped2 = driver.findElement(By.cssSelector("div#dropzone2>p")).getText();
        System.out.println("Is Ball dropped in Dropzone 2: " +dropped2);
        // Close the browser
        driver.quit();
    }
}
