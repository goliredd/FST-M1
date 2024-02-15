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
    # Find the number of rows and columns in the second table
    rows = driver.find_elements(By.XPATH, "//table[contains(@class,'sortable')]/tbody/tr")
    print("No.of rows: ", len(rows))
    cols = driver.find_elements(By.XPATH, "//table[contains(@class,'sortable')]/thead/tr/th")
    print("No.of columns: ", len(cols))
    # Find and print the cell value at the second row second column
    secRowSecCol1 = driver.find_element(By.XPATH, "//table[contains(@class,'sortable')]/tbody/tr[2]/td[2]")
    print("Cell value at the second row second column: ", secRowSecCol1.text)
    # Click the header of the first column to sort by name
    driver.find_element(By.XPATH, "//table[contains(@class,'sortable')]/thead/tr/th[1]").click()
    # Find and print the cell value at the second row second column
    secRowSecCol2 = driver.find_element(By.XPATH, "//table[contains(@class,'sortable')]/tbody/tr[2]/td[2]")
    print("Cell value at the second row second column: ", secRowSecCol2.text)
    # Print the cell values of the table footer
    footer = driver.find_elements(By.XPATH, "//table[contains(@class,'sortable')]/tfoot/tr/th")
    print("Cell values of the table footer are: ")
    for value in footer:
        print(value.text)