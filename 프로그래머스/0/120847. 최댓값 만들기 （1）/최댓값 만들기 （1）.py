def solution(numbers):
    answer = 0
    
    numbers.sort(reverse=True)
    
    return numbers[0] * numbers[1]