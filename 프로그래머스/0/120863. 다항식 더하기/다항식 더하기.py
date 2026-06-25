def solution(polynomial):
    answer = ''
    
    tmp = polynomial.split(" + ")
    
    number = 0
    x_num = 0
    
    for i in tmp:
        if not 'x' in i:
            number += int(i)
        else:
            if len(i) == 1:
                x_num += 1
            else:
                x_num += int(i[:-1])
    
    if x_num == 0:
        return str(number)
    
    x_part = 'x' if x_num == 1 else str(x_num) + 'x'
    
    if number == 0:
        return x_part
    
    return x_part + ' + ' + str(number)