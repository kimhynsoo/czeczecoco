#4와 7로 이루 어진 수 중  k번째 작은 수 출력
#4 7 44 47 74 77 444 447 474 477 744 747 774 777 ...4444 4447 4474
#dp에 넣고 정렬 후  k번째 인덱스 출력
import sys
from collections import deque
input = sys.stdin.readline

def find_stage(K):
    total =0
    stage=1
    while K>total:
        total += 2**stage
        stage+=1
    return stage-1,total//2
def get_kth_combination(elements,stage,k):
    #n진법을 생각하여 대입하는 것. 중복순열에 k번째를 구하는 것.

    #base: base진법으로 생각  이 문제의 경우 base=2이므로 이진법으로 생각.
    base= len(elements)
    result=[]
    for _ in range(stage):
        result.append(elements[k%base]) #끝자리부터 쌓아준다.
        k//=base
    return ''.join(str(x) for x in reversed(result)) #끝자리부터 쌓았으므로 역순으로 정렬해 문자열로 변환


K=int(input())
stage,prev_count=find_stage(K) #stage는 숫자가 몇번 쓰였는지 1이라면 4,7
                                #2라면 44,47,74,77
                                #prev_count는 이전 stage까지 몇개가 카운트 되었는지
i=K-prev_count #stage단계에 i인덱스가 답. #if stage가 3이면 prev_count는 6일 것
                                    # 4, 7, 44 ,47, 74 ,75
                                    #따라서 K에서 prev_count를 빼주면 stage에서 몇번 인덱스인지
                                    #확인 가능
#print(stage,i)

numbers=[4,7]

print(get_kth_combination(numbers,stage,i))








dp=[]
temp=[]
dp.append(4)
dp.append(7)
cnt=2



















