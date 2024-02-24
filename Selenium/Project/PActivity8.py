from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from selenium.webdriver.support.wait import WebDriverWait
from webdriver_manager.firefox import GeckoDriverManager
from selenium.webdriver.support import expected_conditions as EC

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
    # Navigate to Sales -> Accounts page
    driver.find_element(By.ID, "grouptab_0").click()
    Accounts = driver.find_element(By.CSS_SELECTOR, "ul.navbar-nav li.topnav ul.dropdown-menu li:nth-of-type(2)")
    Accounts.click()
    wait = WebDriverWait(driver, 10)
    # Assert Accounts page
    text = wait.until(EC.visibility_of_element_located((By.XPATH, "//*[@class='moduleTitle']/h2"))).text
    assert " ACCOUNTS" == text
    # Find the table on the page and print the names of the first 5 odd-numbered rows of the table to the console.
    firstRow = driver.find_elements(By.XPATH, "//table[contains(@class,'table-responsive')]/tbody/tr[1]/td")
    print("First row: ")
    for cell in firstRow:
        print(cell.text)
    thirdRow = driver.find_elements(By.XPATH, "//table[contains(@class,'table-responsive')]/tbody/tr[3]/td")
    print("Third row: ")
    for cell in thirdRow:
        print(cell.text)
    fifthRow = driver.find_elements(By.XPATH, "//table[contains(@class,'table-responsive')]/tbody/tr[5]/td")
    print("Fifth row: ")
    for cell in fifthRow:
        print(cell.text)
    seventhRow = driver.find_elements(By.XPATH, "//table[contains(@class,'table-responsive')]/tbody/tr[7]/td")
    print("Seventh row: ")
    for cell in seventhRow:
        print(cell.text)
    ninthRow = driver.find_elements(By.XPATH, "//table[contains(@class,'table-responsive')]/tbody/tr[9]/td")
    print("Ninth row: ")
    for cell in ninthRow:
        print(cell.text)

