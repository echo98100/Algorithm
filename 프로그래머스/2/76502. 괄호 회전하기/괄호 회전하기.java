import java.util.*;
class Solution {
    
    static Queue<Character> q;
    
    public int solution(String s) {
        int answer = 0;
        
        q = new ArrayDeque<>();
        
        for(int i = 0; i < s.length(); i++){
            q.add(s.charAt(i));
        }
        
        for(int i = 0; i < q.size(); i++){
            
            if(check()) answer++;
            
            q.add(q.poll());
        }
        
        return answer;
    }
    
    public boolean check() {
        Stack<Character> stack = new Stack<>();
        
        for(char now : q){
            
            if (now == '(' || now == '[' || now == '{') {
                stack.push(now);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                
                char top = stack.pop();
                
                if (now == ')' && top != '(') {
                    return false;
                }
                
                if (now == ']' && top != '[') {
                    return false;
                }
                
                if (now == '}' && top != '{') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}