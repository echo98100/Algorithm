import java.util.*;
// MST -> 크루스칼 알고리즘 사용
class Solution {
    
    static int[] parents;
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        
        //costs[2] 인 가중치 값으로 costs 배열 정렬
        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });
        parents = new int[n];
        // 유니온파인드를 위한 parents배열 초기화
        for(int i = 0; i < n; i++){
            parents[i] = i;
        }
        
        for(int[] arr : costs){
            if(union(arr[0], arr[1])) {
                answer += arr[2];
            }
        }
        
        return answer;
    }
    
    // 유니온 -> 두 정점의 부모가 다르면 부모를 같게(더 작은 정점으로)
    public boolean union(int n1, int n2){
        int p1 = find(n1);
        int p2 = find(n2);
        if(p1 == p2) return false;
        else {
            if(p1 > p2) parents[p1] = p2;
            else parents[p2] = p1;
        }
        return true;
    }
    
    // 유니온 되어있는 집합에서 해당 정점의 부모 찾기(가장 위)
    public int find(int n){
        if(parents[n] != n) {
            parents[n] = find(parents[n]);
        }
        return parents[n];
    }
}