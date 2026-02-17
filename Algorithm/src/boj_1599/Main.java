package boj_1599;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static Map<String, Integer> dict = new HashMap<>();

    public static class Minsic implements Comparable<Minsic> {
        String origin;
        List<Integer> ranklist; //맵핑해서 순위로 만든 리스트

        public Minsic(String str) {
           this.origin = str;
           this.ranklist = parse(str);
        }

        //dict 맵에 맞춰 숫자로 변경해주는 함수
        public List<Integer> parse(String str) {
            List<Integer> list = new ArrayList<>();

            for(int i = 0; i < str.length(); i++) {

                if((i+1) < str.length() && str.charAt(i) == 'n' && str.charAt(i+1) == 'g') {
                    list.add(dict.get("ng"));
                    i++;
                } else {
                    list.add(dict.get(str.charAt(i)+""));
                }
            }

            return list;
        }

        @Override
        public int compareTo(Minsic o) {

            int length1 = this.ranklist.size();
            int length2 = o.ranklist.size();
            int min = Math.min(length1, length2);

            for(int i = 0; i < min; i++) {
                //들어오는 단어를 맵핑으로 숫자 순위로 치환한 ranklist를 사용해 대소비교
                int r1 = this.ranklist.get(i);
                int r2 = o.ranklist.get(i);
                if(r1 != r2) {
                    return r1 - r2;
                }

            }
            // 둘 중 짧은 단어까지의 문자가 모두 같으면 길이 짧은게 앞으로
            return length1 - length2;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[] order = "a b k d e g h i l m n ng o p r s t u w y".split(" ");

        for(int i = 0; i < 20; i++) {
            dict.put(order[i], i);
        }

        PriorityQueue<Minsic> pq = new PriorityQueue<>();

        for(int i = 0; i < N; i++) {
            pq.add(new Minsic(br.readLine()));
        }
        while(!pq.isEmpty()) {
            System.out.println(pq.poll().origin);
        }

    }
}
