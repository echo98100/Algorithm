from collections import deque

def solution(maps):
    answer = 0
    
    answer = bfs(maps)
    
    return answer

def bfs(maps):
    n = len(maps)
    m = len(maps[0])
    
    visited = [[False] * m for _ in range(n)]
    
    dr = [-1, 0, 0, 1]
    dc = [0, -1, 1, 0]
    
    q = deque()
    q.append((0,0,1))
    visited[0][0] = True

    while q:
        r, c, dist = q.popleft()
        
        if r == n-1 and c == m-1:
            return dist
        
        for d in range(4):
            nr = r + dr[d]
            nc = c + dc[d]
            
            if nr >= 0 and nr < n and nc >= 0 and nc < m and visited[nr][nc] == False and maps[nr][nc] == 1:
                visited[nr][nc] = True
                q.append((nr,nc,dist+1))
            
    return -1



