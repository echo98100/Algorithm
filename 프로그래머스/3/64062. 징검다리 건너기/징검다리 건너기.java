import java.util.*;
class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        
        // 이분탐색으로 1 ~ 200000000 명 사이에서 정답 찾기
        // n이 가능하다면 n보다 작은 값들은 무조건 가능하므로
        int left = 1;
        int right = 200000000; // stone의 최대값
        
        while(left <= right) {
            
            int mid = (left+right)/2;
            
            if(verify(stones, k, mid)) {
                answer = mid;
                left = mid+1;
            } else {
                right = mid-1;
            }
            
        }
        
        return answer;
    }
    
    public boolean verify(int[] stones, int k, int num) {
        
        int count = 0;
        
        for(int stone : stones) {
            
            if(stone < num) {
                count++;
            } else {
                count = 0;
            }
            
            if(count == k){
                return false;
            }
        }
        
        
        return true;
    }
}