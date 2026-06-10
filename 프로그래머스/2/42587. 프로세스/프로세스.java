import java.util.*;
class Solution {
    
    static class Process {
        int idx, priority;
        
        public Process(int idx, int priority) {
            this.idx = idx;
            this.priority = priority;
        }
        
    }
    
    public int solution(int[] priorities, int location) {
        int answer = 0;    
        
        Queue<Process> q = new ArrayDeque<>();
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        int n = 0;
        for(int p : priorities) {
            q.add(new Process(n++, p));
            pq.add(p);
        }
        int count = 0;
        while(true){
            
            Process now = q.poll();
            
            if(now.priority < pq.peek()) {
                q.add(now);
            } else {
                pq.poll();
                count++;
                if(now.idx == location) {
                answer = count;
                break;
            }
            }
            
            
        }
        
        return answer;
    }
}