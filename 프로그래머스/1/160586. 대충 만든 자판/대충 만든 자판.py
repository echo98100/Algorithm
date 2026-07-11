def solution(keymap, targets):
    answer = []
    
    for target in targets:
        
        sum = 0
        for i in target:
            loc = 101
            for now in keymap:
                if i in now and now.index(i) < loc:
                    loc = now.index(i)

            if loc == 101:
                sum = -1
                break
            
            sum += loc + 1
        
        answer.append(sum)
        
    return answer