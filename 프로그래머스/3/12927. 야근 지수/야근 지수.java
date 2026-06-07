import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        int sum = 0;
        for(int w : works){
            pq.add(w);
            sum += w;
        }
        
        if(sum <= n) return 0;
        
        while(n-- > 0) {
            
            pq.add(pq.poll()-1);

        }
        
        while(!pq.isEmpty()){
            
            answer += Math.pow(pq.poll(), 2);
        }
        
        return answer;
    }
}