class Solution:
    def concatWithReverse(self, nums: list[int]) -> list[int]:

        answer = []
        
        for i in nums:
            answer.append(i)

        for i in nums[::-1]:
            answer.append(i)    
        
        return answer

        
        