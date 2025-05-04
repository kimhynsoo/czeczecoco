import sys
from collections import deque
input = sys.stdin.readline
tickets=[list(map(str,input().strip().split(" "))) for _ in range(5)]

# #BFS
# answer=[]
# q=deque()
# q.append(("ICN",["ICN"],[]))
#
# while q:
#     airport,path,used=q.popleft()
#
#     if len(used)==len(tickets):
#         answer.append(path)
#
#     for idx,ticket in enumerate(tickets):
#         if ticket[0] == airport and not idx in used:
#             q.append((ticket[1],path+[ticket[1]],used+[idx]))
#
# answer.sort()
# print(answer[0])

#DFS
visited = [False]*(len(tickets))
answer=[]

def dfs(airport,path):
    if len(path) == len(tickets)+1:
        answer.append(path)
        return

    for idx, ticket in enumerate(tickets) :
        if ticket[0]==airport and visited[idx]==False :
            visited[idx]=True
            dfs(ticket[1],path+[ticket[1]])
            visited[idx]=False

dfs("ICN",["ICN"])
answer.sort()

print(answer[0])



