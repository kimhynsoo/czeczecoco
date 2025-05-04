import sys
from collections import deque
input=sys.stdin.readline

rectangle=[list(map(int,input().split())) for _ in range(4)]
characterX,characterY=map(int,input().split())
itemX,itemY=map(int,input().split())
dx = [0, 1, -1, 0]
dy = [-1, 0, 0, 1]

maps = [[0] * 101 for _ in range(101)]
me = [[0] * 101 for _ in range(101)]

for i in range(len(rectangle)):
    l_d_x, l_d_y = rectangle[i][0]*2, rectangle[i][1]*2
    r_u_x, r_u_y = rectangle[i][2]*2, rectangle[i][3]*2
    for y in range(l_d_y,r_u_y+1):
        if maps[y][l_d_x]==1 or maps[y][l_d_x]==0:
            maps[y][l_d_x]=1
        if maps[y][r_u_x]==1 or maps[y][r_u_x]==0:
            maps[y][r_u_x]=1

    for x in range(l_d_x,r_u_x+1):
        if maps[l_d_y][x]==1 or maps[l_d_y][x]==0:
            maps[l_d_y][x]=1
        if maps[r_u_y][x]==1 or maps[r_u_y][x]==0:
            maps[r_u_y][x]=1

    for y in range(l_d_y+1,r_u_y):
        for x in range(l_d_x+1,r_u_x):
            maps[y][x]=2


# for row in reversed(maps[:r_u_y+2]):
#     print(''.join(str(cell) for cell in row[:r_u_x+2]))
queue=deque()
queue.append((characterY*2,characterX*2))
maps[characterY*2][characterX*2]=0
while queue:
    y,x = queue.popleft()
    for i in range(4):
        nx = x+dx[i]
        ny = y+dy[i]
        if 0 <= nx <= 100 and 0 <= ny <= 100 and maps[ny][nx] == 1:
            maps[ny][nx]=0
            queue.append((ny,nx))
            me[ny][nx]=me[y][x]+1
            if ny==itemY*2 and nx== itemX*2:
                queue.clear()
                break

print(me[itemY*2][itemX*2]//2)





# for row in reversed(me[:r_u_y+3]):
#     print(''.join(str(cell) for cell in row[:r_u_x+3]))

