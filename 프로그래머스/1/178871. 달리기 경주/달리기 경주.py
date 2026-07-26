def solution(players, callings):
    answer = []
    
    rank = {}
    
    for i, player in enumerate(players):
        rank[player] = i
    
    for name in callings:
        
        now = rank[name]
        front = players[now-1]
        
        players[now], players[now-1] = players[now-1], players[now]
        
        rank[name] -= 1
        rank[front] += 1
        
        
    
    return players

