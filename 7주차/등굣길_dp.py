import sys
def solution(m, n, puddles):
    mod = 10 ** 9 + 7
    dp = [[0] * (m + 1) for _ in range(n + 1)]
    puddles_set = set((y, x) for x, y in puddles)
    dp[1][1] = 1
    for i in range(1, n + 1):
        for j in range(1, m + 1):
            if (i, j) in puddles_set:
                dp[i][j] = 0
            else:
                if i > 1:
                    dp[i][j] += dp[i - 1][j] % mod
                if j > 1:
                    dp[i][j] += dp[i][j - 1] % mod
                dp[i][j] %= mod

    return (dp[n][m])


input=sys.stdin.readline

m,n=map(int,input().split())
puddles=[list(map(int,input().split())) ]
print(solution(m,n,puddles), end='')

