num = tuple(input("Please enter the tuple of numbers separated with space: ").split(" "))
print("Numbers divisible by 5 from the given tuple are: ")
for n in num:
    if int(n) % 5 == 0:
        print(n)
