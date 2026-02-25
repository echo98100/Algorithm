package boj_27737;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int N, M, K;
    static int[][] board;
    static boolean[][] visited;
    static int[] dr = {-1, 0, 0, 1};
    static int[] dc = {0, -1, 1, 0};

    static class Pos {
        int r, c;
        public Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt(); //판의 크기
        M = sc.nextInt(); //포자의 개수
        K = sc.nextInt(); //퍼지는칸

        board = new int[N][N];
        visited = new boolean[N][N];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        int count = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(board[i][j] == 0 && !visited[i][j]) {
                    int area = bfs(i,j);

                    count = count + ((area%K == 0) ? area/K : area/K+1);
                }
            }
        }
        if(count > M || count == 0) {
            System.out.println("IMPOSSIBLE");
        }
        else {
            System.out.println("POSSIBLE");
            System.out.println(M - count);
        }

    }

    //bfs로 하나로 영역의 칸들을 찾자
    public static int bfs(int r, int c) {

        Queue<Pos> q = new ArrayDeque<>();
        q.add(new Pos(r, c));
        visited[r][c] = true;
        int count_area = 1;

        while(!q.isEmpty()) {

            Pos now = q.poll();

            for(int i = 0; i < 4; i++) {
                int nr = now.r + dr[i];
                int nc = now.c + dc[i];

                if(nr >= 0 && nr < N && nc >= 0 && nc < N) {
                    if(board[nr][nc] == 0 && !visited[nr][nc]) {
                        count_area++;
                        visited[nr][nc] = true;
                        q.add(new Pos(nr, nc));
                    }
                }
            }

        }
        return count_area;
    }

}
