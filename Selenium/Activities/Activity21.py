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
    driver.get("https://v1.training-support.net/selenium/tab-opener")
    print("Title of the page is: ", driver.title)
    # Find the button to open a new tab and click it
    driver.find_element(By.ID, "launcher").click()
    # Wait for the new tab to open
    wait = WebDriverWait(driver, 10)
    wait.until(expected_conditions.number_of_windows_to_be(2))
    # Print all the handles
    print("Window handles available so far: ", driver.window_handles)
    # Switch to the newly opened tab
    driver.switch_to.window(driver.window_handles[1])
    # Wait for the new page to load
    wait.until(expected_conditions.visibility_of_element_located((By.ID, "actionButton")))
    # Print it's title and heading
    print("New window's handle: ", driver.current_window_handle)
    print("Title of the new page: ", driver.title)
    pageHeading = driver.find_element(By.XPATH, "//div[@class='content']").text
    print("Page Heading: ", pageHeading)
    # Click the button in the new tab page
    driver.find_element(By.ID, "actionButton").click()
    wait.until(expected_conditions.number_of_windows_to_be(3))
    # Print all the handles
    print("Window handles available so far: ", driver.window_handles)
    # Switch to the newly opened tab
    driver.switch_to.window(driver.window_handles[2])
    # Wait for the new page to load
    wait.until(expected_conditions.visibility_of_element_located((By.CLASS_NAME, "content")))
    # Print it's title and heading
    print("New window's handle: ", driver.current_window_handle)
    print("Title of the new page: ", driver.title)
    pageHeading = driver.find_element(By.CLASS_NAME, "content").text
    print("Page Heading: ", pageHeading)
