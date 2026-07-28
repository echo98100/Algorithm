import java.util.*;
class Solution {
    public int solution(int alp, int cop, int[][] problems) {
        int answer = 0;
        
        int alp_max = 0;
        int cop_max = 0;
        
        for (int[] n : problems){
            alp_max = Math.max(alp_max, n[0]);
            cop_max = Math.max(cop_max, n[1]);
        }
        
        alp_max = Math.max(alp_max, alp);
        cop_max = Math.max(cop_max, cop);
        
        int[][] dp = new int[alp_max+1][cop_max+1];
        int INF = Integer.MAX_VALUE;
        
        for (int i = 0; i <= alp_max; i++) {
            Arrays.fill(dp[i], INF);
        }
        
        dp[alp][cop] = 0;
        
        for(int i = alp; i <= alp_max; i++){
            for(int j = cop; j <= cop_max; j++){
                
                if(dp[i][j] == INF) continue;
                
                if(i < alp_max) dp[i+1][j] = Math.min(dp[i+1][j], dp[i][j] + 1);
                if(j < cop_max) dp[i][j+1] = Math.min(dp[i][j+1], dp[i][j] + 1);
                
                for(int[] n : problems){
                    
                    if(i >= n[0] && j >= n[1]) {
                        
                        int na = Math.min(alp_max, i + n[2]);
                        int nc = Math.min(cop_max, j + n[3]);

                        dp[na][nc] = Math.min(dp[na][nc], dp[i][j] + n[4]);
                        
                    }
                    
                }
                
            }
        }
        
        
        return dp[alp_max][cop_max];
    }
}