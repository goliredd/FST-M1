# Set up the Firefox Driver with WebDriverManger
from selenium.webdriver import ActionChains, Keys
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
    driver.get("https://v1.training-support.net/selenium/drag-drop")
    print("Title of the page is: ", driver.title)
    # Find the ball and simulate a click and drag to move it into "Dropzone 1"
    ball = driver.find_element(By.ID, "draggable")
    droppable = driver.find_element(By.ID, "droppable")
    actions.click_and_hold(ball).move_to_element(droppable).pause(1).release().perform()
    dropped = driver.find_element(By.CSS_SELECTOR, "div#droppable>p").text
    print("Is Ball dropped in Dropzone 1: ", dropped)
    dropzone2 = driver.find_element(By.ID, "dropzone2")
    # Move the ball into "Dropzone 2"
    actions.click_and_hold(ball).move_to_element(dropzone2).pause(1).release().perform()
    dropped2 = driver.find_element(By.CSS_SELECTOR, "div#dropzone2>p").text
    print("Is Ball dropped in Dropzone 2: ", dropped2)

