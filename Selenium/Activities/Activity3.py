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
    # Activity1 with XPath
    driver.get("https://v1.training-support.net")
    print("Title of Activity1 page is: ", driver.title)
    driver.find_element(By.XPATH, "//a[@id = 'about-link']").click()
    print("Title of Activity1 new page is: ", driver.title)
    time.sleep(2)
    # Activity2 with XPath
    driver.get("https://v1.training-support.net/selenium/login-form")
    print("Title of Activity2 page is: ", driver.title)
    # Find username and password and send keys then click the Log in button
    driver.find_element(By.XPATH, "//input[@id = 'username']").send_keys("admin")
    driver.find_element(By.XPATH, "//input[@name = 'Password']").send_keys("password")
    driver.find_element(By.XPATH, "//button[@onclick='signIn()']").click()
    time.sleep(2)
    confirm_Msg = driver.find_element(By.XPATH, "//div[@id='action-confirmation']").text
    print("Login confirmation message: ", confirm_Msg)

