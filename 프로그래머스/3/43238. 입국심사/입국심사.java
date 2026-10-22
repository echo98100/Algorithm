import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        Arrays.sort(times);
        
        //시간을 기준으로, 해당 시간에 각 심사관이 몇명을 심사하는지 더해서
        // 불가능 -> 가능 넘어가는 지점 이분탐색으로 찾기
        
        long left = 1;
        long right = (long)times[times.length-1]*n;
        
        while(left <= right) {
            
            long count = 0;
            long mid = (right+left)/2;
            
            for(int t : times) {
                
                count += mid / (long)t;
                
            }
            
            if(count >= n) {
                answer = mid;
                right = mid-1;
            }
            else {
                left = mid+1;
            }
            
        }
        
        
        
        return answer;
    }
}