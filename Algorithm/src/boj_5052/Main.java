package boj_5052;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int tc = 0; tc < T; tc++) {

            int N = sc.nextInt();

            String[] arr = new String[N];
            for(int i = 0; i < N; i++) {
                arr[i] = sc.next();
            }

            // 정렬 하면 인접한 번호 끼리만 접두사 관계 발생
            Arrays.sort(arr);

            String answer = "YES";

            for(int i = 0; i < N-1; i++) {
                if (arr[i+1].startsWith(arr[i])){
                    answer="NO";
                    break;
                }
            }

            System.out.println(answer);

        } //tc
    }//main
}
