import java.util.*;
class Solution {
    
    static int[][] map;
    static boolean[][] visited;
    
    static int[] dr = {-1, 0, 0, 1};
    static int[] dc = {0, -1, 1, 0};
    
    static int R, C;
    
    static class Pos {
        int r, c;
        public Pos(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    
    public int[] solution(String[] maps) {
        List<Integer> answer = new ArrayList<>();
        
        R = maps.length;
        C = maps[0].length();
        
        map = new int[R][C];
        for(int r = 0; r < R; r++){
            String s = maps[r];
            for(int c = 0; c < C; c++) {
                char now = s.charAt(c);
                if(now == 'X') map[r][c] = 0;
                else map[r][c] = now - '0';
            }
        }
        visited = new boolean[R][C];
        
        for(int r = 0; r < R; r++) {
            for(int c = 0; c < C; c++) {
                if(map[r][c] != 0 && !visited[r][c]){
                    answer.add(bfs(r,c));
                }
            }
        }
        
        if(answer.isEmpty()) answer.add(-1);
        
        Collections.sort(answer);
        
        return answer.stream().mapToInt(c -> c).toArray();
    }
    
    public int bfs(int r, int c){
        int sum = 0;
        
        Queue<Pos> q = new ArrayDeque<>();
        
        q.add(new Pos(r, c));
        visited[r][c] = true;
        sum+=map[r][c];
        
        while(!q.isEmpty()){
            Pos now = q.poll();
            
            for(int i = 0; i < 4; i++){
                int nr = now.r+dr[i];
                int nc = now.c+dc[i];
                
                if(nr>=0 && nr<R && nc>=0 && nc<C){
                    if(!visited[nr][nc] && map[nr][nc] != 0){
                        q.add(new Pos(nr, nc));
                        visited[nr][nc] = true;
                        sum+=map[nr][nc];
                    }
                }
            }
        }
        
        
        return sum;
    }
}