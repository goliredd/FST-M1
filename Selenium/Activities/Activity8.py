# Set up the Firefox Driver with WebDriverManger
import time

from selenium.webdriver import ActionChains, Keys
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

# Set up the Firefox Driver with WebDriverManger
service = FirefoxService(GeckoDriverManager().install())

# Start the Driver
with webdriver.Firefox(service=service) as driver:
    # Set up the actions object
    actions = ActionChains(driver)
    # Open the browser to the URL
    driver.get("https://v1.training-support.net/selenium/dynamic-controls")
    print("Title of the page is: ", driver.title)
    # Find the checkbox and click
    checkbox = driver.find_element(By.ID, "toggleCheckbox")
    checkbox.click()
    time.sleep(1)
    wait = WebDriverWait(driver, 10)
    # Wait till the checkbox disappears
    wait.until(EC.invisibility_of_element_located((By.ID, "dynamicCheckbox")))
    print("Checkbox disappears: ", +checkbox.is_displayed())
    # click the checkbox
    checkbox.click()
    time.sleep(1)
    # Wait till it appears and check the checkbox
    wait.until(EC.visibility_of_element_located((By.ID, "dynamicCheckbox")))
    print("Checkbox appears: ", +checkbox.is_displayed())