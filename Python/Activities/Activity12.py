def sumNum(n):
    if n <= 0:
        return n
    else:
        return n + sumNum(n - 1)


value = sumNum(10)
output = "Sum of Numbers from 0 to 10: {}"
print(output.format(value))
