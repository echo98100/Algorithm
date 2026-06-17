import java.util.*;
class Solution {
    
    public class Work implements Comparable<Work>{
        int num, start, end;
        public Work(int num, int start, int end) {
            this.num = num;
            this.start = start;
            this.end = end;
        }
        
        @Override
        public int compareTo(Work o) {
            
            if(this.end == o.end) {
                
                if(this.start == o.start) {
                    return this.num - o.num;
                }
                return this.start - o.start;
            }
            
            return this.end - o.end;
        }
        
    }
    
    public int solution(int[][] jobs) {
        int answer = 0;
        
        //도착시간 우선순위큐
        PriorityQueue<Work> pq1 = new PriorityQueue<>(
            (a, b) -> {
                if(a.start != b.start) {
                    return a.start - b.start;
                }
                return a.num - b.num;
            }
        );
        
        //작업 우선순위대로 실행할 우선순위큐
        PriorityQueue<Work> pq2 = new PriorityQueue<>();
        
        int idx = 0;
        for(int[] job : jobs) {
            pq1.add(new Work(idx++, job[0], job[1]));
        }
        
        int time = 0;
        int sum = 0;
        
        while(!pq1.isEmpty() || !pq2.isEmpty()){
            
            // 현재 시간까지 들어갈 수 있는 작업들은 작업우선순위큐(pq2에 넣는다)
            while(!pq1.isEmpty() && pq1.peek().start <= time) {
                pq2.add(pq1.poll());
            }
            
            if(!pq2.isEmpty()) {
                
                Work now = pq2.poll();
                
                time += now.end;
                sum += (time - now.start);
            } else {
                //작업목록이 비어있기는데 pq1은 남아있으니까 가져올 수 있도록 시간 점프
                
                time = pq1.peek().start;
            }
            

        }
        
        
        return sum/jobs.length;
    }
}