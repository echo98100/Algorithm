package boj_1531;

import java.util.*;
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt(); //안보이는 겹치는 수

        int[][] map = new int[101][101];

        for(int i = 0; i < N; i++) {

            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();

            for(int r = x1; r <= x2; r++) {
                for(int c = y1; c <= y2; c++) {
                    map[r][c]++;
                }
            }

        }
        int count = 0;

        for(int r = 1; r<=100; r++) {
            for(int c = 1; c<=100; c++) {
                if(map[r][c] > M) {
                    count++;
                }
            }
        }

        System.out.println(count);

    }
}
