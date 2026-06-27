def solution(emergency):
    answer = []
    
    sorted_array = sorted(emergency, reverse=True)
    
    for i in emergency:
        answer.append(sorted_array.index(i)+1)
    
    return answer