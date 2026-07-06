def solution(s):
    answer = 0
    
    eng = ['one', 'two', 'three', 'four', 'five', 'six', 'seven', 'eight', 'nine', 'zero']
    num = ['1', '2', '3', '4', '5', '6', '7', '8', '9', '0']
    
    for i in range(10):
        s = s.replace(eng[i], num[i])
    
    return int(s)