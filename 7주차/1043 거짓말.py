import sys
from collections import deque
input=sys.stdin.readline

n,m=map(int,input().split())
true_people=list(map(int,input().split()))
parties=list(deque(map(int,input().split())) for i in range(m))
#print(true_people)
lie_party=0
parents=[i for i in range(n+1)]

def find(x):
    if parents[x]!=x:
        parents[x]=find(parents[x])
    return parents[x]

def union(a,b):
    root_a=find(a)
    root_b=find(b)
    if root_a!=root_b:
        parents[root_b]=root_a
if true_people[0]!=0 and len(true_people)!=n+1:
    true_people.pop(0)

    for party in parties:
        party.popleft()
    for party in parties:
        for i in range(1,len(party)):
            union(party[0],party[i])

    truth_root=set(find(p) for p in true_people)

    for party in parties:
        if not any(find(p) in truth_root for p in party):
            lie_party+=1


    print(lie_party,end='')
elif len(true_people)==n+1:
    print(0)
else:
    print(m,end='')




