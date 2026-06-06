import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        for(int i = 0; i < prices.length; i++) {
           
            int now = prices[i];
            int sec = prices.length - i - 1;
            for(int j = i+1; j < prices.length; j++) {
                
                if(now > prices[j]) {
                    sec = j-i;
                    break;
                }
                
            }
            answer[i] = sec;
        }
        
        
        
        
        
        return answer;
    }
}