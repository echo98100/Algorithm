package boj_1600;

import java.util.*;

public class Main {

    static int[] dr = {-1, 0, 0, 1};
    static int[] dc = {0, 1, -1, 0};
    static int[] hr = {-2, -1, 1, 2, -2, -1, 1, 2};
    static int[] hc = {-1, -2, -2, -1, 1, 2, 2, 1};

    static int[][] map;
    static boolean[][][] visited;

    static int K,W,H; //hr, hc만큼 움직일 수 있는 횟수

    static class pos {
        int r, c, depth, k;

        public pos(int r, int c, int depth, int k) {
            this.r = r;
            this.c = c;
            this.depth = depth;
            this.k = k;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        K = sc.nextInt();

        W = sc.nextInt();
        H = sc.nextInt();

        map = new int[H][W];
        for(int r = 0; r < H; r++){
            for(int c = 0; c < W; c++) {
                map[r][c] = sc.nextInt();
            }
        }
        visited = new boolean[H][W][K+1];

        System.out.println(bfs(0,0));

    }

    public static int bfs(int r, int c) {

        visited[r][c][0] = true;

        Queue<pos> q = new ArrayDeque<>();
        q.add(new pos(r,c,0,0));

        while(!q.isEmpty()){

            pos now = q.poll();

            if(now.r == H-1 && now.c == W-1) {
                return now.depth;
            }

            if(now.k < K) {
                for(int i = 0; i < 8; i++) {
                    int nr = now.r + hr[i];
                    int nc = now.c + hc[i];

                    if(nr>=0 && nr<H && nc>=0 && nc<W) {
                        if(map[nr][nc] == 0 && !visited[nr][nc][now.k+1]) {
                            visited[nr][nc][now.k+1] = true;
                            q.add(new pos(nr,nc,now.depth+1, now.k+1));
                        }
                    }
                }
            }
            for(int i = 0; i < 4; i++) {
                int nr = now.r + dr[i];
                int nc = now.c + dc[i];

                if(nr>=0 && nr<H && nc>=0 && nc<W) {
                    if(map[nr][nc] == 0 && !visited[nr][nc][now.k]){
                        visited[nr][nc][now.k] = true;
                        q.add(new pos(nr,nc,now.depth+1, now.k));
                    }
                }
            }

        }
        return -1;
    }
}

