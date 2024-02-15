from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager

# Set up the Firefox Driver with WebDriverManger
service = FirefoxService(GeckoDriverManager().install())

# Start the Driver
with webdriver.Firefox(service=service) as driver:
    # Open the browser to the URL
    driver.get("https://v1.training-support.net/selenium/target-practice")
    print("Title of the page is: ", driver.title)
    Third_header_text = driver.find_element(By.XPATH, "//h3[@id='third-header']").text
    print("Text of Third header on the page: ", Third_header_text)
    Fifth_header_element = driver.find_element(By.XPATH, "//h5[@class='ui green header']")
    color = Fifth_header_element.value_of_css_property("color")
    print("Color of fifth header on the page: ", color)
    violet_button = driver.find_element(By.CSS_SELECTOR, ".ui.violet.button")
    att_value = violet_button.get_attribute("class")
    print("Violet button classes: ", att_value)
    grey_button = driver.find_element(By.CSS_SELECTOR, ".ui.grey.button").text
    print("Grey button text: ", grey_button)

