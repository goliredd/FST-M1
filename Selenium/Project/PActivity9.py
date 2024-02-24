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
    # Navigate to Sales -> Leads
    driver.find_element(By.ID, "grouptab_0").click()
    Leads = driver.find_element(By.CSS_SELECTOR, "ul.navbar-nav li.topnav ul.dropdown-menu li:nth-of-type(5)")
    Leads.click()
    wait = WebDriverWait(driver, 10)
    text = wait.until(EC.visibility_of_element_located((By.XPATH, "//*[@class='moduleTitle']/h2"))).text
    assert " LEADS" == text
    # Find the table on the page and print the first 10 values in the Name column and the User column of the table to
    # the console
    nameColumn = driver.find_elements(By.XPATH, "//table[contains(@class,'table-responsive')]/tbody/tr/td[3]")
    print("Name Column values: ")
    counter = 1
    for cell in nameColumn:
        print(cell.text)
        counter += 1
        if counter == 11:
            break
    counter1 = 1
    userColumn = driver.find_elements(By.XPATH, "//table[contains(@class,'table-responsive')]/tbody/tr/td[8]")
    print("User Column values: ")
    for cell in userColumn:
        print(cell.text)
        counter1 += 1
        if counter1 == 11:
            break
