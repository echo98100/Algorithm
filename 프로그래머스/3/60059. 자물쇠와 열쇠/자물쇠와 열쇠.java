class Solution {
    
    static int R, C, N, M;
    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = false;
        
        R = lock.length;
        C = lock[0].length;
        
        N = key.length;
        M = key[0].length;
        
        int[][] n_lock = new int[R+(N-1)*2][C+(M-1)*2];
        
        for(int i = 0; i<R; i++){
            for(int j = 0; j<C; j++){
                n_lock[(N-1)+i][(M-1)+j] = lock[i][j];
            }
        }
        
        for(int rot = 0; rot < 4; rot++) {
            
            for(int i = 0; i <= n_lock.length-N; i++) {
                for(int j = 0; j <= n_lock[0].length-M; j++){
                    
                    for(int r = 0; r < N; r++){
                        for(int c = 0; c < M; c++){
                            n_lock[i+r][j+c] += key[r][c];
                        }
                    }
                    if(check(n_lock)) return true;
                    
                    for(int r = 0; r < N; r++){
                        for(int c = 0; c < M; c++){
                            n_lock[i+r][j+c] -= key[r][c];
                        }
                    }
                }
            }
                
            key = rotate(key);
        }
        
        return answer;
    }
    
    public boolean check(int[][] lock) {
        for (int i = (N-1); i < (N-1)+R; i++) {
            for (int j = (M-1); j < (M-1)+C; j++) {
                if (lock[i][j] != 1) return false;
            }
        }
        return true;
    }
    
    public static int[][] rotate(int[][] key) {
        int n = key.length;
        int m = key[0].length;

        int[][] result = new int[m][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result[j][n - 1 - i] = key[i][j];
            }
        }

        return result;
    }
}