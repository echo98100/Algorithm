package boj_17130;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M;
    static char[][] map;
    static int[][] dp;

    static int[] dr = {-1, 0, 1};
    static int[] dc = {1, 1, 1};

    static class Pos {
        int r, c;
        public Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        Pos rabbit = new Pos(0,0);
        List<Pos> door = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < M; j++) {
                char now = str.charAt(j);
                map[i][j] = now;
                if(now == 'R'){
                    rabbit.r = i;
                    rabbit.c = j;
                } else if(now == 'O') {
                    door.add(new Pos(i,j));
                }
            }
        }

        dp = new int[N][M];

        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -1);
        }
        dp[rabbit.r][rabbit.c] = 0;

        for(int c = rabbit.c; c < M-1; c++) {

            for(int r = 0; r < N; r++) {

                if(dp[r][c] == -1) {
                    continue;
                }

                for(int i = 0; i < 3; i++) {
                    int nr = r + dr[i];
                    int nc = c + dc[i];

                    if(nr >= 0 && nr < N && nc >= 0 && nc < M) {
                        if(map[nr][nc] != '#') {

                            if(map[nr][nc] == 'C') {
                                dp[nr][nc] = Math.max(dp[nr][nc], dp[r][c]+1);
                            } else {
                                dp[nr][nc] = Math.max(dp[nr][nc], dp[r][c]);
                            }

                        }
                    }
                }

            }
        }


        int max = -1;
        for(Pos p : door) {
            max = Math.max(max,dp[p.r][p.c]);
        }
        System.out.println(max);

    }
}
