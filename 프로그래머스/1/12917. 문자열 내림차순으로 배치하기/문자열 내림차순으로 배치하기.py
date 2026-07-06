def solution(s):
    answer = ''
    
    ord_arr = [ord(i) for i in s]
    
    for i in sorted(ord_arr, reverse=True):
        answer += chr(i)
    
    return answer