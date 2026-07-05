def solution(n):
    answer = 0
    
    num = ""
    
    for i in sorted(str(n), reverse = True):
        num += i
    
    return int(num)