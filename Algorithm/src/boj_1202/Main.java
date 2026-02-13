package boj_1202;

import java.util.*;

public class Main {

    static class jem implements Comparable<jem> {
        int weight;
        int price;

        public jem(int weight, int price) {
            this.weight = weight;
            this.price = price;
        }

        @Override
        public int compareTo(jem o) {
            // 무게 가벼운 순대로 정렬
            return this.weight - o.weight;

        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 보석의 개수
        int K = sc.nextInt(); // 가방의 수

        // 우선순위큐는 가격 높은거 먼저 뽑기
        PriorityQueue<jem> pq = new PriorityQueue<>((o1, o2) -> o2.price - o1.price);

        jem[] jems = new jem[N];
        int[] backpack = new int[K];

        for(int i = 0; i<N; i++) {
            jems[i] = new jem(sc.nextInt(), sc.nextInt());
        }

        for(int i = 0; i < K; i++) {
            backpack[i] = sc.nextInt();
        }
        Arrays.sort(jems);
        Arrays.sort(backpack);

        int index = 0;

        long answer = 0;

        // 가벼운 가방부터 해당 가방에 넣을 수 있는 보석들 중에 가장 비싼거 넣기
        for(int i = 0; i < K; i++) {
            int now = backpack[i];

            while(index < N && jems[index].weight <= now){
                pq.add(jems[index]);
                index++;
            }
            if(!pq.isEmpty()) {
                answer += pq.poll().price;
            }

        }

        System.out.println(answer);
    }
}
