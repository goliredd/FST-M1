package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginTestSteps {
    WebDriver driver;
    WebDriverWait wait;

    @Given("^User is on Login page$")
    public void userIsOnLoginPage() {
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        //Open the browser
        driver.get("https://v1.training-support.net/selenium/login-form");
    }
    @When("^User enters username and password$")
    public void userEntersUsernameAndPassword(){
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("password");
        driver.findElement(By.cssSelector("button.button:nth-child(4)")).click();
    }
    @Then("^Read the page title and confirmation message$")
    public void readThePageTitleAndConfirmationMessage(){
        String pageTitle = driver.getTitle();
        String loginMessage = driver.findElement(By.id("action-confirmation")).getText();
        System.out.println("Title of the page: " +pageTitle);
        System.out.println("Login message: " +loginMessage);
    }
    @And("^Close the Browser$")
    public void closeTheBrowser() {
        driver.close();
    }
}
