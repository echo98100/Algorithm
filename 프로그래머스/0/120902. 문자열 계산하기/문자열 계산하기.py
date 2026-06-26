def solution(my_string):
    
    str = my_string.split(' ')
    
    answer = int(str[0])
    
    for i in range(1, len(str), 2):
        operator = str[i]
        num = int(str[i+1])
    
        if operator == '+':
            answer += num
        else:
            answer -= num
    
    return answer