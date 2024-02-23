package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertTestSteps {
    WebDriver driver;
    WebDriverWait wait;
    Alert alert;

    @Given("^User is on the page$")
    public void userIsOnThePage() {
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        //Open the browser
        driver.get("https://v1.training-support.net/selenium/javascript-alerts");
    }
    @When("^User clicks the Simple Alert button$")
    public void userClickTheSimpleAlertButton(){
        driver.findElement(By.id("simple")).click();
    }
    @When("^User clicks the Confirm Alert button$")
    public void userClickTheConfirmAlertButton(){
        driver.findElement(By.id("confirm")).click();
    }
    @When("^User clicks the Prompt Alert button$")
    public void userClickThePromptAlertButton(){
        driver.findElement(By.id("prompt")).click();
    }
    @Then("^Alert opens$")
    public void alertOpens(){
        // Wait for the alert to display
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        // Switch the focus from the main window to the Alert box and print the text in it
        alert = driver.switchTo().alert();
    }
    @And("^Read the text from it and print it$")
    public void readTheTextFromItAndPrintIt(){
        System.out.println("Alert text: " +alert.getText());
    }
    @And("^Write a custom message in it$")
    public void writeACustomMessageInIt(){
        alert.sendKeys("Awesome!");
    }
    @And("^Close the alert$")
    public void closeTheAlert(){
        alert.accept();
    }
    @And("^Close the alert with Cancel$")
    public void closeTheAlertWithCancel(){
        alert.dismiss();
    }
    @And("^Close Browser$")
    public void closeTheBrowser() {
        driver.close();
    }
}
