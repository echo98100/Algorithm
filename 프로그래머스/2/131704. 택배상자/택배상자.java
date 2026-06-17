import java.util.*;
class Solution {
    public int solution(int[] order) {
        int answer = 0;
        
        // 보조 컨테이너 - 스택
        int n = order.length; // 택배의 수
        
        Stack<Integer> stack = new Stack<>();
        
        int cur = 1;
        
        for(int now : order) {
            
            while(cur <= n && cur <= now){
                stack.push(cur++);
            }
            
            if(!stack.isEmpty() && stack.peek() == now){
                stack.pop();
                answer++;
            } else {
                break;
            }
            
        }
        
        
        return answer;
    }
}