def solution(name, yearning, photo):
    answer = []
    
    for i in photo:
        score = 0
        for j in i:
            if j not in name:
                continue
            score += yearning[name.index(j)]
        answer.append(score)
    
    return answer