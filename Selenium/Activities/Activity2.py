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
    driver.get("https://v1.training-support.net/selenium/login-form")
    print("Title of the page is: ", driver.title)
    # Find username and password and send keys then click the Log in button
    driver.find_element(By.NAME, "Username").send_keys("admin")
    driver.find_element(By.ID, "password").send_keys("password")
    driver.find_element(By.XPATH, "//button[@onclick='signIn()']").click()
    time.sleep(2)
    confirm_Msg = driver.find_element(By.ID, "action-confirmation").text
    print("Login confirmation message: ", confirm_Msg)

