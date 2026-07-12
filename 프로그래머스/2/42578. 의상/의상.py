def solution(clothes):
    answer = 1
    
    _map = {}
    
    for name, kind in clothes:
        _map[kind] = _map.get(kind, 0) + 1
    
    for i in _map.values():
        answer *= (i+1)

    return answer - 1