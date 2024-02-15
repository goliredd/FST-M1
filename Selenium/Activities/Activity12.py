import time

from selenium import webdriver
from selenium.webdriver.common.by import By
from webdriver_manager.firefox import GeckoDriverManager
from selenium.webdriver.firefox.service import Service as FirefoxService

# Set up the Firefox Driver with WebDriverManger
service = FirefoxService(GeckoDriverManager().install())

# Start the Driver
with webdriver.Firefox(service=service) as driver:
    # Open the browser to the URL
    driver.get("https://v1.training-support.net/selenium/dynamic-controls")
    print("Title of the page is: ", driver.title)
    # Find the text field and check if enabled
    textField = driver.find_element(By.ID, "input-text")
    print("Is text field enabled: ", textField.is_enabled())
    # Click the "Enable Input" button
    time.sleep(2)
    driver.find_element(By.ID, "toggleInput").click()
    # Check if the text field is enabled
    print("Is text field enabled: ", textField.is_enabled())