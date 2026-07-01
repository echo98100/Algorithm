def solution(s):
    answer = []
    
    for i in range(len(s)):
        for j in range(i-1, -1, -1):
            if s[i] == s[j]:
                answer.append(i-j)
                break
        else:
            answer.append(-1)
    
    return answer