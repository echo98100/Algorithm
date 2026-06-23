def solution(my_string):
    answer = 0
    
    for i in my_string:
        for j in "123456789":
            if i == j:
                answer += int(j)
    
    return answer