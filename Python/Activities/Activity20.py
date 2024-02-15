import pandas
dataframe = pandas.read_excel('userdetails.xlsx')
# Printing full data
print(dataframe)
# Printing number of rows and columns
print("Number of rows and columns: " + str(dataframe.shape))
# Printing data in the emails column only
print("************************")
print("Data in the emails column: ")
print(dataframe['Email'])
# Printing FirstName in ascending order
print("************************")
print("FirstName in ascending order: ")
print(dataframe.sort_values('FirstName'))
