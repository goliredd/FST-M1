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
    # Find the checkbox and verify if selected
    checkbox = driver.find_element(By.NAME, "toggled")
    print("Is checkbox is selected: ", checkbox.is_selected())
    # click the checkbox
    checkbox.click()
    time.sleep(2)
    print("Is checkbox is selected: ", checkbox.is_selected())
