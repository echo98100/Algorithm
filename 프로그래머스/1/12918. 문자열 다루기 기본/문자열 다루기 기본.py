def solution(s):
    answer = True
    
    if len(s) != 4 and len(s) != 6:
        return False
    
    for i in s:
        if i not in '1234567890':
            return False
    
    return answer