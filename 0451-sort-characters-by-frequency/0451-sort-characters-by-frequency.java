import java.util.*;

class Solution {

    static class Count implements Comparable<Count>{
        char c;
        int count;
        public Count(char c, int count){
            this.c =c ;
            this.count = count;
        }

        @Override
        public int compareTo(Count c) {
            return this.count - c.count;
        }
    }

    public String frequencySort(String s) {
        
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i = 0; i<s.length(); i++) {
            char c = s.charAt(i);

            map.put(c, map.getOrDefault(c, 0)+1);

        }

        PriorityQueue<Count> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(Character c : map.keySet()) {
            pq.add(new Count(c, map.get(c)));
        }

        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()) {

            Count now = pq.poll();

            for(int i = 0; i < now.count; i++) {
                sb.append(now.c);
            }
        }

        return sb.toString();
    }
}