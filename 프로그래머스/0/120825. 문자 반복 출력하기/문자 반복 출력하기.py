def solution(my_string, n):
    answer = ''
    
    for i in my_string:
        answer += ''.join(i*n)
    
    return answer