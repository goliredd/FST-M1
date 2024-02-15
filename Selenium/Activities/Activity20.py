import time

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
    driver.get("https://v1.training-support.net/selenium/javascript-alerts")
    print("Title of the page is: ", driver.title)
    # Find the button to open a PROMPT alert and click it
    driver.find_element(By.ID, "prompt").click()
    # Switch the focus from the main window to the Alert box and print the text in it
    alert = driver.switch_to.alert
    print("Alert text: ", alert.text)
    # Type "Awesome!" into the prompt
    alert.send_keys("Awesome!")
    time.sleep(2)
    # Close the alert with Ok
    alert.accept()
