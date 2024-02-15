# Set up the Firefox Driver with WebDriverManger
from selenium.webdriver import ActionChains
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager

# Set up the Firefox Driver with WebDriverManger
service = FirefoxService(GeckoDriverManager().install())

# Start the Driver
with webdriver.Firefox(service=service) as driver:
    # Set up the actions object
    actions = ActionChains(driver)
    # Open the browser to the URL
    driver.get("https://v1.training-support.net/selenium/input-events")
    print("Title of the page is: ", driver.title)
    # Perform Left click and print the value of the side in the front
    actions.click().pause(1).perform()
    getText = driver.find_element(By.CLASS_NAME, "active").text
    print(getText)
    # Perform Double click to show a random side and print the number
    actions.double_click().pause(1).perform()
    randomSideText = driver.find_element(By.CLASS_NAME, "active").text
    print(randomSideText)
    # Perform Right click and print the value shown on the front of the cube
    actions.context_click().pause(1).perform()
    frontSideText = driver.find_element(By.CLASS_NAME, "active").text
    print(frontSideText)
