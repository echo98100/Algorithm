def solution(array):
    answer = 0
    
    numset = set(array)
    
    max = 0
    for i in numset:
        if max < array.count(i):
            max = array.count(i)
            answer = i
        elif max == array.count(i):
            answer = -1
    
    return answer