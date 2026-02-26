package boj_1090;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static checker[] list;
    static int N;

    static class checker {
        int x, y;
        public checker(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static List<Integer> dist;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        list = new checker[N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            list[i] = new checker(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        long[] ans = new long[N];
        Arrays.fill(ans, Integer.MAX_VALUE);

        //주어진 점들의 x,y좌표 모든 조합 고려
        for(int xi = 0; xi < N; xi++) {
            for(int yi = 0; yi < N; yi++) {

                dist = new ArrayList<>();
                calDist(list[xi].x, list[yi].y);
                long sum = 0;
                //각 가능한 후보에 대해서 입력 점들과의 거리를 구해놨으니까
                //이제 이 중에서 몇개 뽑을지 더해서 최소값 갱신
                for(int i = 0; i < N; i++) {
                    sum += dist.get(i);
                    ans[i] = Math.min(ans[i], sum);
                }
            }
        }

        for(int i = 0; i < N; i++) {
            System.out.print(ans[i]+ " ");
        }

    }


    static void calDist(int xi, int yi) {

        for(checker c : list) {
            dist.add((Math.abs(xi - c.x)) + (Math.abs(yi - c.y)));
        }
        Collections.sort(dist);
    }

}
