def solution(progresses, speeds):
    answer = []
    
    time = []
    
    for i in range(len(progresses)):
        time.append(((100 - progresses[i]) + (speeds[i]) -1) // speeds[i])
    
    time.reverse()
    
    while len(time) > 0 :
        
        now = time.pop()
        count = 1
        while len(time) > 0 and now >= time[len(time)-1]:
            time.pop()
            count += 1
        
        answer.append(count)
    
    return answer