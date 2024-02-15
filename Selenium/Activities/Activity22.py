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
    driver.get("https://v1.training-support.net/selenium/popups")
    print("Title of the page is: ", driver.title)
    # Find the Sign-in button and hover over it
    button = driver.find_element(By.CLASS_NAME, "orange")
    # Set up actions object
    actions = webdriver.ActionChains(driver)
    actions.move_to_element(button).perform()
    # Print the tooltip message
    toolTip = button.get_attribute("data-tooltip")
    print("Tooltip message: ", toolTip)
    # Click the button to open the Sign-in form
    button.click()
    # Enter the credentials and click login
    driver.find_element(By.NAME, "Username").send_keys("admin")
    driver.find_element(By.ID, "password").send_keys("password")
    driver.find_element(By.XPATH, "//button[@onclick='signIn()']").click()
    time.sleep(2)
    confirm_Msg = driver.find_element(By.ID, "action-confirmation").text
    print("Login confirmation message: ", confirm_Msg)

