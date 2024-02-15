fruits = dict(banana=10, apple=20, kiwi=30)
fruitCheck = input("Let me know the fruit you are looking for? ").lower()
if fruitCheck in fruits:
    print(fruitCheck, " is available")
else:
    print(fruitCheck, " is not available")
