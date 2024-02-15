def fibonacci(number):
    if number <= 1:
        return number
    else:
        return fibonacci(number - 1) + fibonacci(number - 2)


given_num = int(input("Enter how many Fibonacci numbers to generate: "))
if given_num <= 0:
    print("Please enter a number greater than 0")
else:
    print("Fibonacci series is: ")
    for i in range(given_num):
        print(fibonacci(i))
