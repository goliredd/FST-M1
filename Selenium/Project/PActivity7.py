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
    # Find the Additional information icon at the end of the row of the lead information then Click it
    driver.find_element(By.XPATH, "//*[@id='adspan_1fefe55c-77e6-e7f6-d8cb-5db0c115c3f9']").click()
    # Read the popup and print the phone number displayed in it
    Mobile =wait.until(EC.visibility_of_element_located((By.CSS_SELECTOR, "div>span.phone:nth-of-type(1)")))
    print("phone number: ", Mobile.text)

