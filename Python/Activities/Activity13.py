def sum(*num):
    n = 0
    for number in num:
        n += number
    return n


result = sum(1, 2, 3, 4, 5)
print("The sum of all elements: " + str(result))
