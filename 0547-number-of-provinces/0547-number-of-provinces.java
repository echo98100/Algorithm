// 2. 유니온 파인드
class Solution {

    static int N;
    static int[] parent;

    public int findCircleNum(int[][] isConnected) {
        
        N = isConnected.length;

        parent = new int[N];

        // 부모를 자기자신으로 초기화 
        for(int i = 0; i < N; i++){
            parent[i] = i;
        }

        for(int r = 0; r < N; r++){
            for(int c = 0; c < N; c++){
                if(isConnected[r][c] == 1){
                    union(r,c);
                }
            }
        }

        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < N; i++){
            set.add(find(i));
        }
        return set.size();
    }

    // find 연산
    public static int find(int x) {
        //부모를 찾았으니 부모 리턴
        if(parent[x] == x) return x;

        // 재귀로 부모 타고 타고 찾기 + 경로 압축
        return parent[x] = find(parent[x]);
    }

    // union 연산
    public static void union(int x, int y) {
        x = find(x);
        y = find(y);

        //이미 같은 부모에 속해있는 경우
        if(x == y) return;

        if(x < y) parent[y] = x;
        else parent[x] = y;
        return;
    }
}