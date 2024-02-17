package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class Activity5 {
    WebDriver driver;
    @BeforeClass(alwaysRun = true)
    public void BeforeMethod(){
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
        WebDriverManager.firefoxdriver().setup();
        // Create a new instance of the Firefox driver
        driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/target-practice");
    }

    @Test
    public void pageTitle(){
        String PageTitle = driver.getTitle();
        System.out.println("Print the title of the page: " +PageTitle);
        Assert.assertEquals("Target Practice",  PageTitle);
    }

    @Test(groups = {"HeaderTests"})
    public void header3(){
        WebElement thirdHeader = driver.findElement(By.tagName("h3"));
        Assert.assertEquals("Third header", thirdHeader.getText());
    }

    @Test(groups = {"HeaderTests"})
    public void header5(){
        WebElement fifthHeader = driver.findElement(By.tagName("h5"));
        Assert.assertEquals("rgb(33, 186, 69)", fifthHeader.getCssValue("color"));
    }

    @Test(groups = {"ButtonTests"})
    public void oliveButton(){
        WebElement oliveButton = driver.findElement(By.cssSelector("button.olive"));
        Assert.assertEquals("Olive", oliveButton.getText());
    }

    @Test(groups = {"ButtonTests"})
    public void brownButton(){
        WebElement firstButton3Row = driver.findElement(By.className("brown"));
        Assert.assertEquals("rgb(255, 255, 255)", firstButton3Row.getCssValue("color") );
    }

    @AfterClass(alwaysRun = true)
    public void AfterMethod(){
        driver.close();
    }
}
