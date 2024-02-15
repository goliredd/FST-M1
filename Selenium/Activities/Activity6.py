# Set up the Firefox Driver with WebDriverManger
from selenium.webdriver import ActionChains, Keys
from selenium import webdriver
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
    # Press the key of first letter of your name in caps
    actions.send_keys("A").pause(1).perform()
    # Press CTRL+a and the CTRL+c to copy all the text on the page
    actions.key_down(Keys.CONTROL).send_keys("a").send_keys("c").key_up(Keys.CONTROL).perform()

