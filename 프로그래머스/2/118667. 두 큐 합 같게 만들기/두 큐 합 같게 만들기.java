import java.util.*;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = -2;
        
        int size = queue1.length + queue2.length;
        
        Queue<Integer> q1 = new ArrayDeque<>();
        Queue<Integer> q2 = new ArrayDeque<>();
        
        long sum1 = 0;
        long sum2 = 0;
        
        for(int n : queue1){
            sum1 += n;
            q1.add(n);
        }
        for(int n : queue2){
            sum2 += n;
            q2.add(n);
        }
        
        if(sum1 == sum2) return 0;
        
        // 작업 횟수
        int count = 0;
        
        while(count <= size*2){
            
            if(sum1 > sum2){
                
                int num = q1.poll();
                
                q2.add(num);
                sum1 -= num;
                sum2 += num;
                count++;
                
            }else {
                int num = q2.poll();
                
                q1.add(num);
                sum1 += num;
                sum2 -= num;
                count++;
            }
            
            if(sum1 == sum2) return count;
        }
        
        return -1;
    }
}