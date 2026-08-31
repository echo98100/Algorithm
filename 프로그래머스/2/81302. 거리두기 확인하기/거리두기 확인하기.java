class Solution {
    
    // 거리 1
    static final int[] dr1 = {-1, 0, 0, 1};
    static final int[] dc1 = {0, 1, -1, 0};
    
    // 거리 2 대각선
    static final int[] dr2 = {-1, -1, 1, 1};
    static final int[] dc2 = {-1, 1, -1, 1};
    
    // 거리2 직선
    static final int[] dr3 = {-2, 0, 0, 2};
    static final int[] dc3 = {0, -2, 2, 0};
    
    static int n;
    
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        
        n = 5;
        
        for(int i = 0; i < places.length; i++) {
            
            String[] now = places[i];
            
            boolean valid = true;
            
            for(int r = 0; r < n; r++) {
                for(int c = 0; c < n; c++) {
                    
                    if(now[r].charAt(c) == 'P') {
                        
                        if(!check(now, r, c)) {
                            valid = false;
                        }
                    }
                    
                }
            }
            
            answer[i] =  valid ? 1 : 0; 
            
        }
        
        return answer;
    }
    
    public boolean check(String[] place, int now_r, int now_c) {
        
        // 거리 1 다른 응시자
        for(int i = 0; i < 4; i++) {
            int nr = dr1[i] + now_r;
            int nc = dc1[i] + now_c;
            
            if(isOut(nr, nc)) continue;
            
            if(place[nr].charAt(nc) == 'P') return false;
        }
        
        // 거리 2 대각선
        for(int i = 0; i < 4; i++) {
            int nr = dr2[i] + now_r;
            int nc = dc2[i] + now_c;
            
            if(isOut(nr, nc)) continue;
            
            if(place[nr].charAt(nc) == 'P') {
                
                int midR1 = now_r;
                int midC1 = nc;
                
                int midR2 = nr;
                int midC2 = now_c;
                
                if(place[midR1].charAt(midC1) != 'X' || place[midR2].charAt(midC2) != 'X') {
                    return false;
                }
            }
            
        }
        
        // 직선 거리 2
        for(int i = 0; i < 4; i++) {
            
            int nr = dr3[i] + now_r;
            int nc = dc3[i] + now_c;
            
            if(isOut(nr, nc)) continue;
            
            if(place[nr].charAt(nc) == 'P') {
                int midR = (nr+now_r) / 2;
                int midC = (nc+now_c) / 2;
                
                if(place[midR].charAt(midC) != 'X'){
                    return false;
                }
            }
        }
        
        
        return true;
    }
    
    public boolean isOut(int nr, int nc) {
        if(nr<0 || nr>=n || nc<0 || nc>=n) return true;
        return false;
    }
}