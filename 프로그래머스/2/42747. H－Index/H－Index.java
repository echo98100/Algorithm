import java.util.*;
class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        int n = citations.length;
        
        Arrays.sort(citations);
        
        // 0 1 3 5 6
        // 1 2 3 4 5
        // 0 1 2 3 4
        int max = 0;
        for(int i = 0; i < n; i++) {
            
            int now = citations[i];
            int h = Math.min(now, n-i);
            
            max = Math.max(max,h);
            
        }
        
        return max;
    }
}