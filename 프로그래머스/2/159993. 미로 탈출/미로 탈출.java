import java.util.*;
class Solution {
    
    static char[][] map;
    static boolean[][] visited;
    
    static int[] dr = {-1, 0, 0, 1};
    static int[] dc = {0, -1, 1, 0};
    
    static int start_r;
    static int start_c;
    
    static class Pos {
        int r, c, time;
        public Pos(int r, int c, int time) {
            this.r = r;
            this.c = c;
            this.time = time;
        }
    }
    static int R,C;
    
    static boolean lever;
    
    public int solution(String[] maps) {
        int answer = 0;
        
        start_r = 0;
        start_c = 0;
        
        R = maps.length;
        C = maps[0].length();
        
        map = new char[R][C];
        for(int i = 0; i < maps.length; i++) {
            String now = maps[i];
            for(int j = 0; j < now.length(); j++) {
                map[i][j] = now.charAt(j);
                if(now.charAt(j) == 'S') {
                    start_r = i;
                    start_c = j;
                }
            }
        }
        
        visited = new boolean[R][C];
        lever = false;
        // 레버찾기
        int temp = bfs(start_r, start_c, 0);
        
        // visited 초기화 후, 레버 좌표를 출발지로 출구 찾기
        visited = new boolean[R][C];
        answer = bfs(start_r, start_c, temp);
        
        return answer;
    }
    
    public int bfs(int r, int c, int time) {
        
        Queue<Pos> q = new ArrayDeque<>();
        q.add(new Pos(r,c,time));
        visited[r][c] = true;
        
        while(!q.isEmpty()) {
            
            Pos now = q.poll();
            
            for(int i = 0; i < 4; i++){
                int nr = now.r + dr[i];
                int nc = now.c + dc[i];
                
                if(nr>=0 && nr<R && nc>=0 && nc<C) {
                    if(!visited[nr][nc] && map[nr][nc] != 'X'){
                        //레버를 찾으면 레버 좌표 저장 및 종료
                        if(map[nr][nc] == 'L' && !lever) {
                            start_r = nr;
                            start_c = nc;
                            lever = true;
                            return now.time + 1;
                        }
                        //레버를 찾은 상태로 출구 도착시 종료
                        if(map[nr][nc] == 'E' && lever) {
                            return now.time + 1;
                        }
                        q.add(new Pos(nr, nc, now.time + 1));
                        visited[nr][nc] = true;
                    }
                }
                
            }
            
        }
        return -1;
    }
}