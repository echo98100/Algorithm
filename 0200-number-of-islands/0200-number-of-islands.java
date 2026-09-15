import java.util.*;

class Solution {
    
    static int R, C;

    static int[] dr = {-1, 0, 0, 1};
    static int[] dc = {0, -1, 1, 0};

    static class Pos {
        int r, c;
        public Pos(int r, int c){
            this.r = r;
            this.c = c;
        }
    }

    static boolean[][] visited;
    static int answer;

    public int numIslands(char[][] grid) {
        
        R = grid.length;
        C = grid[0].length;

        answer = 0;
        visited = new boolean[R][C];

        for(int r = 0; r < R; r++){
            for(int c = 0; c < C; c++){

                if(grid[r][c] == '1' && !visited[r][c]){
                    bfs(r,c,grid);
                    answer++;
                }
            }
        }
        return answer;
    }

    public void bfs(int r, int c, char[][] grid){

        Queue<Pos> q = new ArrayDeque<>();

        q.add(new Pos(r, c));
        visited[r][c] = true;

        while(!q.isEmpty()){

            Pos now = q.poll();

            for(int i = 0; i < 4; i++) {
                int nr = dr[i]+now.r;
                int nc = dc[i]+now.c;

                if(nr>=0 && nr<R && nc>=0 && nc<C && !visited[nr][nc]){
                    if(grid[nr][nc] != '0'){
                        q.add(new Pos(nr,nc));
                        visited[nr][nc] = true;
                    }
                }

            }
        }

    }


}