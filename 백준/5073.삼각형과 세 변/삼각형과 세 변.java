import sys

while True :
    arr = list(map(int, sys.stdin.readline().split()))
    arr.sort(reverse=True)
    A = arr[0]
    B = arr[1]
    C = arr[2]
    if A == B == C == 0 :
        break

    if arr[0] == arr[1] == arr[2] :
        print("Equilateral")
    elif arr[0] < arr[1] + arr[2] :
        if A != B and B != C and C != A :
            print("Scalene")
        else :
            print("Isosceles")
        
    else :
        print("Invalid")
