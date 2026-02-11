# 1
# 2 ~ 7 (6) / 2
# 8 ~ 19 (12) / 3
# 20 ~ 37 (18) / 4
# 38 ~ 61 (24) / 5
import sys

# 1 + 1 + 6 + 12 + 18 + 24
N = int(sys.stdin.readline())
s = 2
k = 2
if N == 1 :
    print(1)
else: 
    while True :
        if N in range(k, k + 6*(s-1)) :
            print(s)
            break
        else :
            k = k + 6*(s-1)
            s += 1
