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
    # Get the first copyright text in the footer
    CopyWriteText =driver.find_element(By.ID, "admin_options").text
    print("first copyright text in the footer: ", CopyWriteText)


