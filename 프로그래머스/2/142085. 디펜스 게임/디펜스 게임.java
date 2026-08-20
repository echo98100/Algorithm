import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        
        // pq에는 무적권 대상만 유지 -> k개 보다 size가 커지면 가장 작은거 poll
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int pq_sum = 0;
        int total = 0;
        
        for(int i = 0; i < enemy.length; i++){
            
            total += enemy[i];
            
            pq_sum += enemy[i];
            pq.add(enemy[i]);
            
            if(pq.size() > k) {
                
                pq_sum -= pq.poll();
                
            }
            // 실제 소모 병력
            if(total - pq_sum > n) return i;

            
        }
        
        return enemy.length;
    }
}