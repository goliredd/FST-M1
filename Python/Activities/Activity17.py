# import pandas
import pandas

# Structure our data as a dictionary
data = {
    "Usernames": ["admin", "Charles", "Deku"],
    "Passwords": ["password", "Charl13", "AllMight"]
    }

# Create a new DataFrame using the data
dataframe = pandas.DataFrame(data)

print(dataframe)

# Write the data to a csv file
# Using same folder as it will be easy while uploading to Github
dataframe.to_csv("usernamepswd.csv", index=False)