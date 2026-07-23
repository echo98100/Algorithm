def solution(s):
    answer = []
    
    s = s.replace('{', '[')
    s = s.replace('}', ']')
    s = eval(s)
    
    sorted_s = sorted(s, key = lambda x: len(x))
    
    answer.append(sorted_s[0][0])
    
    for i in range(1, len(sorted_s)):
        for j in sorted_s[i]:
            if not j in sorted_s[i-1]:
                answer.append(j)
    
    
    return answer