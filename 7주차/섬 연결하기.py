import sys
from collections import defaultdict

input = sys.stdin.readline

n = int(input())
m = int(input())
costs = [list(map(int, input().split())) for _ in range(m)]
# parent=[0]*n
# for i in range(n):
#     parent[i]=i
parent=[i for i in range(n)]

def find_parent(parent,x):
    if parent[x] !=x:
        parent[x]=find_parent(parent,parent[x])
    return parent[x]

def union(parent,a,b):
    a=find_parent(parent,a)
    b=find_parent(parent,b)
    if a<b :
        parent[b]=a
    else:
        parent[a]=b

costs.sort(key = lambda x : x[2])
total_cost=0
v=0
for i in range(m):
    a,b,cost=costs[i]

    if find_parent(parent,a) !=find_parent(parent,b):
        union(parent,a,b)
        total_cost+=cost
        v += 1
        if v == n-1:
            break

print(total_cost)


