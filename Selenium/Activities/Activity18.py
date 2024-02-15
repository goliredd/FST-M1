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
    dropdown = driver.find_element(By.ID, "multi-select")
    select = Select(dropdown)
    # Select the "JavaScript" option using the visible text
    select.select_by_visible_text("Javascript")
    # Select the 4th, 5th and 6th options using the index
    select.select_by_index(3)
    select.select_by_index(4)
    select.select_by_index(5)
    # Select the "NodeJS" option using the value
    select.select_by_value("node")
    # Print selected options
    allSelected = select.all_selected_options
    print("So far selected options: ")
    for option in allSelected:
        print(option.text)
    # Deselect the 5th option using index
    select.deselect_by_index(4)
    # print final selected options
    allSelected = select.all_selected_options
    print("Final selected options: ")
    for option in allSelected:
        print(option.text)
