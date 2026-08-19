class Solution {
    public String solution(int n) {
        String answer = "";
        
        while(true) {
            
            int now = n%3;
            
            if(now == 1) answer = "1" + answer;
            if(now == 2) answer = "2" + answer;
            if(now == 0) {
                answer = "4" + answer;
                n--;
            }
            
            n /= 3;
            
            if(n == 0) break;
            
        }
        
        return answer;
    }
}