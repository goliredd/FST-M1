
def test_assertSum(initialize_list):
    sum = 0
    for n in initialize_list:
        sum+= n
    print("Sum of numbers in list is: " +str(sum))
    assert sum == 55

