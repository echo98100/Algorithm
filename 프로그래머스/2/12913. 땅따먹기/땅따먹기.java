import java.util.*;
class Solution {
    int solution(int[][] land) {
        int answer = 0;
        
        int R = land.length;
        int C = land[0].length;

        int[][] dp = new int[R][C];
        
        dp[0] = land[0];
        
        for(int r = 1; r < R; r++){
            
            dp[r][0] = land[r][0] + Math.max(dp[r-1][1], Math.max(dp[r-1][2], dp[r-1][3]));
            dp[r][1] = land[r][1] + Math.max(dp[r-1][0], Math.max(dp[r-1][2], dp[r-1][3]));
            dp[r][2] = land[r][2] + Math.max(dp[r-1][1], Math.max(dp[r-1][0], dp[r-1][3]));
            dp[r][3] = land[r][3] + Math.max(dp[r-1][1], Math.max(dp[r-1][2], dp[r-1][0]));
                
        }
        
        Arrays.sort(dp[R-1]);
        
        return dp[R-1][C-1];
    
    }
}