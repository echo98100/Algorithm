class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        
        int R = board.length;
        int C = board[0].length;
        
        int[][] save = new int[R+1][C+1];
        
        for(int[] cmd : skill) {
            
            int type = cmd[0] == 1 ? -1 : 1;
            
            int sr = cmd[1];
            int sc = cmd[2];
            int er = cmd[3];
            int ec = cmd[4];
            int deg = (type)*cmd[5];
            
            // 이중for문 -> 시간초과남
            // 직사각형 꼭짓점 좌표로 누적합을 구해야함
            save[sr][sc] += deg;
            save[sr][ec+1] -= deg;
            save[er+1][sc] -= deg;
            save[er+1][ec+1] += deg;
            
        }
        
        // 누적합 계산 가로
        for(int r = 0; r < R; r++) {
            for(int c = 0; c < C; c++) {
                save[r][c+1] += save[r][c]; 
            }
        }
        // 누적합 계산 세로
        for(int c = 0; c < C; c++) {
            for(int r = 0; r < R; r++) {
                save[r+1][c] += save[r][c]; 
            }
        }
        
        for(int r = 0; r < R; r++) {
            for(int c = 0; c < C; c++) {
                board[r][c] += save[r][c];
            }
        }
        
        for(int r = 0; r < R; r++) {
            for(int c = 0; c < C; c++) {
                if (board[r][c] >= 1) answer++;
            }
        }
        
        return answer;
    }
}