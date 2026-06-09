import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Arrays.fill(answer, -1);
        
        //인덱스를 관리
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0; i < numbers.length; i++) {
            
            if(stack.isEmpty()) {
                stack.push(i);
            }
            if(numbers[stack.peek()] < numbers[i]) {
                while(!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                    answer[stack.pop()] = numbers[i];
                }
            }
            stack.push(i);
        }
        
        
        
        return answer;
    }
}