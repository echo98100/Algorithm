package boj_5212;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static class Pos {
        int r, c;
        public Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int R = sc.nextInt();
        int C = sc.nextInt();

        char[][] map = new char[R+2][C+2];
        for(int i = 0; i < R+2; i++) {
            for(int j = 0; j < C+2; j++){
                map[i][j] = '.';
            }
        }
        for(int i = 1; i <= R; i++) {
            String str = sc.next();
            for(int j = 1; j <= C; j++) {
                map[i][j] = str.charAt(j-1);
            }
        }

        int[] dr = {-1,0,0,1};
        int[] dc = {0,-1,1,0};

        ArrayList<Pos> save = new ArrayList<>();

        for(int r = 1; r <= R; r++) {
            for(int c = 1; c <= C; c++) {
                int count = 0;

                if(map[r][c] == 'X') {
                    for (int i = 0; i < 4; i++) {
                        int nr = r + dr[i];
                        int nc = c + dc[i];

                        if (map[nr][nc] == '.') count++;
                    }
                }
                if(count >= 3) {
                    save.add(new Pos(r,c));
                }
            }
        }

        for(int i = 0; i < save.size(); i++) {
            map[save.get(i).r][save.get(i).c] = '.';
        }

        //가로 체크
        int startR = R+2;
        int endR = -1;
        int startC = C+2;
        int endC = -1;

        for(int r = 0; r < R+2; r++){
            for(int c = 0; c < C+2; c++) {
                if(map[r][c] == 'X') {
                    startR = Math.min(startR, r);
                    endR = Math.max(endR, r);
                    startC = Math.min(startC, c);
                    endC = Math.max(endC, c);
                }
            }
        }


        for(int r = startR; r <= endR; r++) {
            for(int c = startC; c <= endC; c++) {
                System.out.print(map[r][c]);
            }
            System.out.println();
        }


    }
}
