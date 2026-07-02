def solution(s):
    answer = 0
    
    idx = 0
    
    while idx < len(s):
        
        x = s[idx]
        x_count = 1
        y_count = 0
        
        tmp_idx = idx+1
        
        while tmp_idx < len(s) and x_count != y_count:
            
            if s[tmp_idx] == x:
                x_count += 1
            else:
                y_count += 1
            
            tmp_idx += 1
        
        idx = tmp_idx 
        answer += 1
    
    return answer