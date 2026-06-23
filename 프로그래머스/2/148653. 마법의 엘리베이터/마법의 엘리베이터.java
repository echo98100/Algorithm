class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        while(storey > 0){
            
            int remainder = storey%10;
            
            if(remainder < 5) {
                answer += remainder;
                storey /= 10;
            } else if(remainder > 5){
                answer += 10 - remainder;
                storey = storey / 10 + 1;
            } else {
                
                int next = (storey/10) % 10;
                
                if(next < 5) {
                    answer += remainder;
                    storey /= 10;
                } else {
                    answer += 10 - remainder;
                    storey = storey / 10 + 1;
                }
                
            }
            
        }
        
        return answer;
    }
}