class Solution {
    
    static int N, M;
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        String answer = ""; // d l r u 
        
        N = n;
        M = m;
        
        int now_r = x;
        int now_c = y;
        
        
        while(k-- > 0) {
            
            if (check(now_r+1, now_c, r, c, k)) {
                answer += "d";
                now_r += 1;
            } else if (check(now_r, now_c-1, r, c, k)){
                answer += "l";
                now_c -= 1;
            } else if (check(now_r, now_c+1, r, c, k)){
                answer += "r";
                now_c += 1;
            } else if (check(now_r-1, now_c, r,c,k)){
                answer += "u";
                now_r -= 1;
            } else {
                return "impossible";
            }
        }
        
        return answer;
    }
    
    public boolean check(int nr, int nc, int r, int c, int k) {
        
        if(nr<=0 || nr>N || nc<=0 || nc>M){
            return false;
        }
        
        int dist = Math.abs(nr-r) + Math.abs(nc-c);
        
        if (dist == k) {
            return true;
        }
        if (dist < k && (k-dist)%2 == 0) return true;
        
        
        return false;
    }
}