package boj_16951;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); //탑의 개수
        long K = sc.nextLong(); //두 탑의 높이 차

        long[] tower = new long[N];
        for(int i = 0; i < N; i++){
            tower[i] = sc.nextLong();
        }

        HashMap<Long, Integer> map = new HashMap<>();

        //공차가 K인 등차수열을 만족하지 않는 개수가 최소가 되도록
        for(int i = 0; i < N; i++) {

            long nowDiff = tower[i] - (long) i*K;
            if( nowDiff < 1) continue;

            if(!map.containsKey(nowDiff)){
                map.put(nowDiff, 1);
            } else {
                map.replace(nowDiff, map.get(nowDiff)+1);
            }

        }

        int max = Integer.MIN_VALUE;

        for(long n : map.keySet()) {
            max = Math.max(max, map.get(n));
        }

        int min = N-max;

        System.out.println(min);


    }
}
