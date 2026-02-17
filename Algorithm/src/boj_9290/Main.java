package boj_9290;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();

        test_case:
        for(int T = 1; T<=tc; T++){

            char[][] map = new char[3][3];

            for(int i = 0; i < 3; i++) {
                String str = sc.next();
                for(int j = 0; j < 3; j++) {
                    map[i][j] = str.charAt(j);
                }
            }
            char nam = sc.next().charAt(0);

            for(int r = 0; r < 3; r++) {
                for(int c = 0; c < 3; c++) {

                    if(map[r][c] == '-') {
                        map[r][c] = nam;
                        if(valid(map, nam)){
                            System.out.println("Case " + T + ":");

                            for(int i = 0; i <3; i++) {
                                for(int j = 0; j < 3; j++) {
                                    System.out.print(map[i][j]);
                                }
                                System.out.println();
                            }
                            continue test_case;
                        }
                        map[r][c] = '-';
                    }
                    //백트래킹
                }
            }




        }//tc
    }//main

    static boolean valid(char[][] map, char nam) {

        int[][] dr = {{-1, -2, 1, 2}, {0, 0, 0, 0}, {-1, -2, 1, 2}, {-1, -2, 1, 2}};
        int[][] dc = {{0, 0, 0, 0}, {-1, -2, 1, 2}, {1, 2, -1, -2}, {-1, -2, 1, 2}};

        for(int r = 0; r < 3; r++) {
            for(int c = 0; c < 3; c++) {

                if(map[r][c] == nam) {

                    for(int i = 0; i < 4; i++) {
                        int count = 1;
                        for(int j = 0; j < 4; j++) {
                            int nr = r + dr[i][j];
                            int nc = c + dc[i][j];

                            if(nr >= 0 && nr < 3 && nc >= 0 && nc < 3) {
                                if(map[nr][nc] == nam){
                                    count++;
                                }
                            }
                        }
                        if(count == 3) return true;
                    }

                }

            }
        }
        return false;
    }
}
