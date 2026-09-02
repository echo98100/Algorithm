class Solution {
    public int solution(int n) {
        int answer = 0;
        
        String trit = "";
        
        while(true) {
            
            if((n/3) == 0) {
                trit = String.valueOf(n%3) + trit;
                break;
            }
            
                
            trit = String.valueOf(n%3) + trit;
            n = n/3;
            
        }

        String reversed = "";
        
        for(int i = trit.length() - 1; i >= 0; i--) {
            reversed += trit.charAt(i);
        }

        for(int i = 0; i < reversed.length(); i++) {
            int digit = reversed.charAt(i) - '0';
            answer += digit * Math.pow(3, reversed.length() - 1 - i);
        }
        
        return answer;
    }
}