def solution(score):
    answer = []
    
    avg = [sum(i)/2 for i in score]
    
    sorted_avg = sorted(avg, reverse = True)
    
    for i in avg:
        answer.append(sorted_avg.index(i)+1)
    
    return answer