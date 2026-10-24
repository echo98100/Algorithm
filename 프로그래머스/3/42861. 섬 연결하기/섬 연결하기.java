import java.util.*;

class Solution {
    
    static class Edge implements Comparable<Edge> {
        int from, to, cost;
        
        public Edge(int from, int to, int cost){
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
        
        @Override
        public int compareTo (Edge o){
            return this.cost - o.cost;
        }
    }
    
    static int[] parent;
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        
        List<Edge> edges = new ArrayList<>();
        
        // 우선은 부모를 모두 자기자신으로 초기화
        parent = new int[n];
        for(int i = 0; i < n; i++){
            parent[i] = i;
        }
        
        for(int[] cost : costs){
            edges.add(new Edge(cost[0], cost[1], cost[2]));
            edges.add(new Edge(cost[1], cost[0], cost[2]));
        }
        
        // 유니온 파인드를 활용한 크루스칼 알고리즘 실행
        
        // 먼저 간선리스트 edges를 cost 오름차순으로 정렬
        Collections.sort(edges);
        
        // 간선을 하나씩 꺼내서 볼건데, n-1개의 간선이 선택되면 모두 다 연결한거니까 종료
        int count = 0; // 몇개 선택했는지 체크할 count 변수
        
        for(Edge e : edges){
            
            // e가 잇고 있는 from과 to가 사이클 없이 연결되면
            if(union(e.from, e.to)) {
                // 해당 간선 선택 -> 해당 간선의 cost 합산하고 count 1증가
                answer += e.cost;
                count++;
                
                // 간선을 n-1개 다 찾았으면 종료
                if(count == n-1) {
                    break;
                }
            } // union fales라면 사이클이 있는거니까 해당 간선은 패스
            else {
                continue;
            }
            
            
        }
        
        
        
        return answer;
    }
    
    // 유니온 파인드 구현
    
    // 입력받은 노드의 부모를 찾는 find 메서드
    // 자기 자신이면 return x
    // 아니면 parent[x] 에 find(parent[x]) 를 넣어가며 경로압축하며 찾기
    public int find(int x) {
        if(parent[x] == x) return x;
        
        return parent[x] = find(parent[x]);
    }
    
    // 두 노드를 하나의 부모로 합치는 union 메서드
    // 사이클 판단을 위해 boolean 반환
    
    
    public boolean union(int x1, int x2) {
        
        // 먼저 입력받은 두 노드의 부모를 find 로 찾는다.
        int p1 = find(x1);
        int p2 = find(x2);
        
        // 둘의 부모가 같다면 사이클이 생겼으므로 유니온 진행 안하고 false 반환
        if(p1 == p2) return false;
        
        // 사이클이 없으면 부모 합치기 진행 -> 더 작은 쪽으로 큰쪽을 변경
        if(p1 > p2) parent[p1] = p2;
        else parent[p2] = p1;
        
        // 유니온이 진행되었으니 true 반환
        return true;
        
    }
    
}