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
    # Find the button to open a CONFIRMATION alert and click it
    driver.find_element(By.ID, "confirm").click()
    # Wait for the alert to display
    wait = WebDriverWait(driver, 10)
    wait.until(expected_conditions.alert_is_present())
    # Switch the focus from the main window to the Alert box and print the text in it
    alert = driver.switch_to.alert
    time.sleep(2)
    print("Alert text: ", alert.text)
    # Close the alert with Ok
    alert.accept()
    # close the alert with Cancel
    # alert.dismiss()
