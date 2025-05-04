def kruskal(n, edges):
    parent = [i for i in range(n + 1)]

    def find(x):
        if parent[x] != x:
            parent[x] = find(parent[x])
        return parent[x]

    def union(a, b):
        rootA = find(a)
        rootB = find(b)
        if rootA != rootB:
            if rootA<rootB:
                parent[rootB] = rootA
            else :
                parent[rootA] = rootB
            return True
        return False

    edges.sort(key=lambda x: x[2])  # 가중치 기준 정렬
    mst_weight = 0
    for u, v, weight in edges:
        if union(u, v):
            mst_weight += weight

    return mst_weight
n = 4
edges = [
    (1, 2, 1),
    (2, 3, 2),
    (1, 3, 2),
    (3, 4, 1)
]
print(kruskal(n, edges))  # 출력: 4

