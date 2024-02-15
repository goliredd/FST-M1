list1 = [1, 2, 3, 4, 5, 6, 7]
list2 = [8, 9, 10, 11, 12, 13]
print("First list", list1)
print("Second list", list2)
list3 = []
for n in list1:
    if n % 2 != 0:
        list3.append(n)
for m in list2:
    if m % 2 == 0:
        list3.append(m)
print("Result list is odds from list1 & evens from list2:", list3)



