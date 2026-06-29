def solution(arr):
    answer = []
    
    arr.remove(sorted(arr)[0])
    
    if len(arr) == 0:
        return [-1]
    
    return arr