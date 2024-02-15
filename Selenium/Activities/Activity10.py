import time

from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager

# Set up the Firefox Driver with WebDriverManger
service = FirefoxService(GeckoDriverManager().install())

# Start the Driver
with webdriver.Firefox(service=service) as driver:
    # Open the browser to the URL
    driver.get("https://v1.training-support.net/selenium/dynamic-controls")
    print("Title of the page is: ", driver.title)
    # Find the checkbox and verify if it is displayed
    dynamicCheckbox = driver.find_element(By.ID, "dynamicCheckbox")
    print("Is checkbox visible on the page: ", dynamicCheckbox.is_displayed())
    time.sleep(1)
    # Click the Remove checkbox
    driver.find_element(By.ID, "toggleCheckbox").click()
    print("Is checkbox visible on the page: ", dynamicCheckbox.is_displayed())
