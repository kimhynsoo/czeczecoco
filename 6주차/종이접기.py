import sys
from collections import deque
def rev_col(k):
    if(k==0):
        return 1
    elif k==1 :
        return 0
    elif k==2 :
        return 3
    else :
        return 2

def rev_row(k):
    if k==0 :
        return 2
    elif k==1 :
        return 3
    elif k==2 :
        return 0
    else :
        return 1
input= sys.stdin.readline

k=int(input())
order=deque(input().split())
shot=int(input())
set=deque()

pop=order.pop()
if pop=='R' or pop=='L':
    if pop=='R':
        while True:
            pop=order.pop()
            if(pop=='U' or pop=='D'):
                if(pop=='U'): #RU
                    set.append(shot);
                    set.appendleft(rev_col(shot));
                    set.append(rev_row(rev_col(shot)))
                    set.append(rev_row(shot))
                    break
                else : #RD
                    set.append(shot);
                    set.appendleft(rev_col(shot));
                    set.appendleft(rev_row(shot))
                    set.appendleft(rev_row(rev_col(shot)))
                    break
    else : #L
        while True:
            pop=order.pop()
            if(pop=='U' or pop=='D'):
                if(pop=='U'): #LU
                    set.append(shot);
                    set.append(rev_col(shot));
                    set.append(rev_row(shot))
                    set.append(rev_row(rev_col(shot)))
                    break
                else : #LD
                    set.append(shot);
                    set.append(rev_col(shot));
                    set.appendleft(rev_row(rev_col(shot)))
                    set.appendleft(rev_row(shot))
                    break
else:
    if pop=='U':
        while True:
            pop=order.pop()
            if(pop=='R' or pop=='L'):
                if(pop=='R'): #RU
                    set.append(shot);
                    set.appendleft(rev_col(shot));
                    set.append(rev_row(rev_col(shot)))
                    set.append(rev_row(shot))
                    break
                else : #LU
                    set.append(shot);
                    set.append(rev_col(shot));
                    set.append(rev_row(shot))
                    set.append(rev_row(rev_col(shot)))
                    break
    else : #D
        while True:
            pop=order.pop()
            if(pop=='R' or pop=='L'):
                if(pop=='R'): #RD
                    set.append(shot);
                    set.appendleft(rev_col(shot));
                    set.appendleft(rev_row(shot))
                    set.appendleft(rev_row(rev_col(shot)))
                    break
                else : #LD
                    set.append(shot);
                    set.append(rev_col(shot));
                    set.appendleft(rev_row(rev_col(shot)))
                    set.appendleft(rev_row(shot))
                    break


set=list(set)
row_even=(set[:2]*(2**k))[:2**k]
row_odd=(set[2:]*(2**k))[:2**k]

for i in range(2**k):
    if i%2==0:
        print(*row_even)
    else:
        print(*row_odd)






