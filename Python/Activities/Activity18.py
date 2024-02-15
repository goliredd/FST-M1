import pandas

dataframe = pandas.read_csv('usernamepswd.csv')
# Printing full data
print("Full data")
print(dataframe)
# Printing the values only in the Usernames column
print("***************************")
print("Usernames: ")
print(dataframe["Usernames"])
# Printing the username and password of the second row
print("***************************")
print("Username and password of second row: ")
print(dataframe["Usernames"][1], dataframe["Passwords"][1])
# Printing Usernames column data in ascending order
print("***************************")
print("Usernames column data in ascending order: ")
print(dataframe.sort_values("Usernames"))
# Printing Passwords column in descending order
print("***************************")
print("Passwords column data in descending order: ")
print(dataframe.sort_values("Passwords", ascending=False))