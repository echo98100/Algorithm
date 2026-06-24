import java.util.*;
class Solution {
    public String solution(String number, int k) {
        String answer = "";
        
        Stack<Character> stack = new Stack<>();
        
        for(char now : number.toCharArray()){
            
            while(!stack.isEmpty() && k > 0 && stack.peek() < now){
                stack.pop();
                k--;
            }
            stack.push(now);
        }
        
        while(k>0){
            stack.pop();
            k--;
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(char c : stack){
            sb.append(c);
        }
        
        return sb.toString();
    }
}