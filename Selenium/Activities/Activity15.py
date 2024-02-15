from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support import expected_conditions
from selenium.webdriver.support.wait import WebDriverWait
from webdriver_manager.firefox import GeckoDriverManager
from selenium.webdriver.firefox.service import Service as FirefoxService

# Set up the Firefox Driver with WebDriverManger
service = FirefoxService(GeckoDriverManager().install())

# Start the Driver
with webdriver.Firefox(service=service) as driver:
    # Open the browser to the URL
    driver.get("https://v1.training-support.net/selenium/dynamic-attributes")
    print("Title of the page is: ", driver.title)
    # Find the username and password input fields and type in the credentials
    driver.find_element(By.XPATH, "//input[starts-with(@class,'username-')]").send_keys("admin")
    driver.find_element(By.XPATH, "//input[starts-with(@class,'password-')]").send_keys("password")
    driver.find_element(By.CSS_SELECTOR, "button.ui.button:nth-child(4)").click()
    # Wait for login message to appear and print the login message
    wait = WebDriverWait(driver, 10)
    confirmMsg = wait.until(expected_conditions.visibility_of_element_located((By.ID, "action-confirmation")))
    print("Login Message: ", confirmMsg.text)
