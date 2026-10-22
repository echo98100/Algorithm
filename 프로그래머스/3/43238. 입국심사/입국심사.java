import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        //times 중 F -> T 경계값 이분탐색
        Arrays.sort(times);
        
        long left = 1;
        long right = (long) times[times.length-1]*n;
        
        while(left <= right){
            
            long mid = (left + right)/2;
            long count = 0;
            
            for(int t : times) {
               count += mid / (long) t;
            }
            
            if(count >= n){
                answer = mid;
                right = mid-1;
            } else {
                left = mid+1;
            }
            
        }
        
        
        return answer;
    }
}