import pandas
from pandas import ExcelWriter

data = {
    'FirstName': ["Satvik", "Avinash", "Lahri"],
    'LastName': ["Shah", "Kati", "Rath"],
    'Email': ["satshah@example.com", "avinashk@example.com", "lahri.rath@example.com"],
    'PhoneNumber': ["4537829158", "5892184058", "4528727830"]
}

# Create a new DataFrame using the data
dataframe = pandas.DataFrame(data)
print(dataframe)

# Create an ExcelWriter object
# Using same folder as it will be easy while uploading to Github
writer = ExcelWriter("userdetails.xlsx")

# Write the DataFrame to the Excel file
dataframe.to_excel(writer, "Sheet1", index=False)

# Saves and close the file
writer.close()
