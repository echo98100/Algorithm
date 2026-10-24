import java.util.*;

class Solution {
    
    static class Pos {
        int r, c, time;
        
        public Pos(int r, int c, int time){
            this.r = r;
            this.c = c;
            this.time = time;
        }
    }
    
    static int[] dr = {-1, 0, 0, 1};
    static int[] dc = {0, -1, 1, 0};
    
    static char[][] map;
    static boolean[][] visited;
    
    static int R, C;
    
    public int solution(String[] maps) {
        int answer = 0;
        
        R = maps.length;
        C = maps[0].length();
        
        int S_r = 0;
        int S_c = 0;
        int L_r = 0;
        int L_c = 0;
        int E_r = 0;
        int E_c = 0;
        
        map = new char[R][C];
        
        for(int r = 0; r < R; r++){
            for(int c = 0; c < C; c++){
                
                map[r][c] = maps[r].charAt(c);
                
                if(map[r][c] == 'S'){
                    S_r = r;
                    S_c = c;
                }
                
                if(map[r][c] == 'L'){
                    L_r = r;
                    L_c = c;
                }
                
            }
        }
        
        visited = new boolean[R][C];
        
        int lever = bfs(S_r, S_c, 'L');
        
        if(lever == -1) return -1;
        
        visited = new boolean[R][C];
        
        int end = bfs(L_r, L_c, 'E');
        
        if(end == -1) return -1;
        
        return lever + end;
    }
    
    public int bfs(int start_r, int start_c, char destination) {
        
        Queue<Pos> q = new ArrayDeque<>();
        
        visited[start_r][start_c] = true;
        q.add(new Pos(start_r, start_c, 0));
        
        while(!q.isEmpty()){
            
            Pos now = q.poll();
            
            if(map[now.r][now.c] == destination) return now.time;
            
            for(int i = 0; i < 4; i++){
                int nr = now.r + dr[i];
                int nc = now.c + dc[i];
                
                if(nr>=0 && nr<R && nc>=0 && nc<C){
                    if(map[nr][nc] != 'X' && !visited[nr][nc]) {
                        visited[nr][nc] = true;
                        q.add(new Pos(nr,nc, now.time + 1));
                    }
                }
            }
            
        }
        
        
        
        return -1;
    }
}