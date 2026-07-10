def solution(n, lost, reserve):
    answer = n - len(lost)
    
    for i in lost[:]:
        if i in reserve:
            reserve.remove(i)
            lost.remove(i)
            answer += 1
    
    for i in sorted(reserve):
        if (i-1) in lost:
            answer += 1
            lost.remove(i-1)
        elif (i+1) in lost:
            answer += 1
            lost.remove(i+1)
    
    return answer