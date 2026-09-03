def solution(num_list):
    answer = []
    
    sorted_arr = sorted(num_list)
    
    for i in range(5):
        answer.append(sorted_arr[i])
    
    return answer