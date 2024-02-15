from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support import expected_conditions
from selenium.webdriver.support.wait import WebDriverWait
from webdriver_manager.firefox import GeckoDriverManager
from selenium.webdriver.firefox.service import Service as FirefoxService

# Set up the Firefox Driver with WebDriverManger
service = FirefoxService(GeckoDriverManager().install())

# Start the Driver
with (webdriver.Firefox(service=service) as driver):
    # Open the browser to the URL
    driver.get("https://v1.training-support.net/selenium/dynamic-attributes")
    print("Title of the page is: ", driver.title)
    # Find the input fields of the Sign-Up form and fill the details
    driver.find_element(By.CSS_SELECTOR, "input[class$='-username']").send_keys("Jerry")
    driver.find_element(By.CSS_SELECTOR, "input[class$='-password']").send_keys("password")
    driver.find_element(By.XPATH, "//label[text()='Confirm Password']/following::input[1]").send_keys("password")
    driver.find_element(By.CSS_SELECTOR, "input[class^='email-']").send_keys("jerry.j1@gmail.com")
    driver.find_element(By.CSS_SELECTOR, "button.ui.button:nth-child(6)").click()
    # Wait for success message to appear and print it
    wait = WebDriverWait(driver, 10)
    successMsg = wait.until(expected_conditions.visibility_of_element_located((By.ID, "action-confirmation"))).text
    print("Success message: ", successMsg)
