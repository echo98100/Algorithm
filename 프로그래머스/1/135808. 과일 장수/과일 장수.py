def solution(k, m, score):
    answer = 0
    
    sorted_arr = sorted(score, reverse = True)
    
    for i in sorted_arr[m-1::m]:
        answer += i * m
        
    
    return answer