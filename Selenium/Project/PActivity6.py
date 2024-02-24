from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager

# Set up the Firefox Driver with WebDriverManger
service = FirefoxService(GeckoDriverManager().install())

# Start the Driver
with webdriver.Firefox(service=service) as driver:
    # Open the browser to the URL
    driver.get("http://alchemy.hguy.co/crm")
    # Find and select the username and password fields and enter the credentials
    driver.find_element(By.NAME, "user_name").send_keys("admin")
    driver.find_element(By.NAME, "username_password").send_keys("pa$$w0rd")
    # Click login
    driver.find_element(By.ID, "bigbutton").click()
    # Locate the navigation menu
    driver.find_element(By.CLASS_NAME, "navbar-nav")
    Activities = driver.find_element(By.ID, "grouptab_3")
    # Ensure that the “Activities” menu item exists
    assert "ACTIVITIES" == Activities.text
