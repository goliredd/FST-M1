from selenium import webdriver
from selenium.webdriver.common.by import By
from webdriver_manager.firefox import GeckoDriverManager
from selenium.webdriver.firefox.service import Service as FirefoxService

# Set up the Firefox Driver with WebDriverManger
service = FirefoxService(GeckoDriverManager().install())

# Start the Driver
with webdriver.Firefox(service=service) as driver:
    # Open the browser to the URL
    driver.get("https://v1.training-support.net/selenium/tables")
    print("Title of the page is: ", driver.title)
    # Find the number of rows and columns in the table
    rows = driver.find_elements(By.XPATH, "//table[contains(@class,'striped')]/tbody/tr")
    print("No.of rows: ", len(rows))
    cols = driver.find_elements(By.XPATH, "//table[contains(@class,'striped')]/tbody/tr[1]/td")
    print("No.of cols: ", len(cols))
    # Find and print all the cell values in the third row of the table
    thirdRow = driver.find_elements(By.XPATH, "//table[contains(@class,'striped')]/tbody/tr[3]/td")
    print("Cell values in the third row of the table are: ")
    for cell in thirdRow:
        print(cell.text)
    # Find and print the cell value at the second row second column
    secRowSecCol = driver.find_element(By.XPATH, "//table[contains(@class,'striped')]/tbody/tr[2]/td[2]")
    print("Cell value at the second row second column: ", secRowSecCol.text)