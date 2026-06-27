def solution(n):
    answer = []
    
    numset = set()
    
    for i in range(2,n+1):
        while n%i == 0:
            n = n // i
            numset.add(i)
    
    for i in numset:
        answer.append(i)
    
    answer = sorted(answer)
    
    return answer