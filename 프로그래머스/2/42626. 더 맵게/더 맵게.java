import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int s : scoville){
            pq.add(s);
        }
        
        while(!pq.isEmpty()) {
            
            int now = pq.poll();
            
            if(now >= K) break;
            
            if(pq.size() >= 1){
                pq.add(now + pq.poll()*2);
                answer++;
            } else {
                return -1;
            }
            
        }
        
        return answer;
    }
}