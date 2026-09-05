import java.util.*;

class Solution {

    static int R, C;

    static int[] dr = {-1, 0, 0, 1};
    static int[] dc = {0, -1, 1, 0};

    static boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        
        R = board.length;
        C = board[0].length;

        char start = word.charAt(0);

        visited = new boolean[R][C];

        for(int r = 0; r < R; r++) {
            for(int c = 0; c < C; c++) {

                if(board[r][c] != start) continue;

                if(dfs(board, r, c, 0, word)) return true;
            }
        }

        return false;

    }

    public boolean dfs(char[][] board, int r, int c, int index, String word) {

        // word를 찾은 경우 
        if(index == word.length()) return true;

        // 범위 밖
        if(r < 0 || r >= R || c < 0 || c >= C) return false;
        
        // 다른 단어
        if(board[r][c] != word.charAt(index)) return false;

        if(visited[r][c]) return false;

        visited[r][c] = true;

        for(int i = 0 ; i < 4; i++) {
            int nr = dr[i] + r;
            int nc = dc[i] + c;

            if(dfs(board, nr, nc, index + 1, word)) return true; 
            
        }

        // 해당 칸 확인 다 했으니 백트래킹
        visited[r][c] = false;

        return false;
    }
}