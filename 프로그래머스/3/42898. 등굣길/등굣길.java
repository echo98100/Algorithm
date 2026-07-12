import java.util.*;
class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        
        int[][] map = new int[n+1][m+1];
        boolean[][] puddle = new boolean[n+1][m+1];
    
        for(int[] p : puddles) {
            puddle[p[1]][p[0]] = true;
        }
        
        map[1][1] = 1;
        
        for(int r = 1; r <= n; r++){
            for(int c = 1; c <= m; c++) {
                
                if (r == 1 && c == 1) continue;
                
                if (puddle[r][c]) continue;
                
                map[r][c] = (map[r-1][c] + map[r][c-1])%1000000007;
                
            }
        }
        
        
        
        return map[n][m];
    }
}