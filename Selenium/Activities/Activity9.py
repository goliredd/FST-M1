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
    driver.get("https://v1.training-support.net/selenium/ajax")
    print("Title of the page is: ", driver.title)
    # Find Change content button and click
    driver.find_element(By.CLASS_NAME, "violet").click()
    wait = WebDriverWait(driver, 10)
    text = wait.until(EC.presence_of_element_located((By.TAG_NAME, "h1"))).text
    print("Message that appears on the page: ", text)
    wait.until(EC.text_to_be_present_in_element((By.TAG_NAME, "h3"), "I'm late!"))
    text1 = driver.find_element(By.TAG_NAME, "h3").text
    print("The new message on the page: ", text1)
