from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support import expected_conditions
from selenium.webdriver.support.select import Select
from selenium.webdriver.support.wait import WebDriverWait
from webdriver_manager.firefox import GeckoDriverManager
from selenium.webdriver.firefox.service import Service as FirefoxService

# Set up the Firefox Driver with WebDriverManger
service = FirefoxService(GeckoDriverManager().install())

# Start the Driver
with webdriver.Firefox(service=service) as driver:
    # Open the browser to the URL
    driver.get("https://v1.training-support.net/selenium/selects")
    print("Title of the page is: ", driver.title)
    # Store the select and make a new select object
    dropdown = driver.find_element(By.TAG_NAME, "select")
    select = Select(dropdown)
    # Select the second option using the visible text
    select.select_by_visible_text("Option 2")
    print("Second option: ", select.first_selected_option.text)
    # Select the third option using the index
    select.select_by_index(3)
    print("Third option: ", select.first_selected_option.text)
    # Select the fourth option using the value
    select.select_by_value("4")
    print("Fourth option: ", select.first_selected_option.text)
    # Get all the options and print them
    options = select.options
    print("All options: ")
    for option in options:
        print(option.text)

