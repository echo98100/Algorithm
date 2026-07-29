class Solution {
    public int solution(int n, int[] cores) {
        
        // n번째 작업이 처음부터 바로 배정되는 경우
        if (n <= cores.length) {
            return n;
        }
        
        long left = 0;
        long right = 1000000000L;
        long time = 0;
        
        // n번째 작업이 끝나는 최소 시간 찾기
        while (left <= right) {
            
            long mid = (left + right) / 2;
            
            long count = cores.length; // 0초에 각 코어가 하나씩 처리한 작업
            
            for (int core : cores) {
                count += mid / core;
            }
            
            if (count >= n) {
                time = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        // time - 1초까지 처리된 작업 개수
        long completed = cores.length;
        
        for (int core : cores) {
            completed += (time - 1) / core;
        }
        
        // time초에 처리되는 작업 중 몇 번째인지
        long remain = n - completed;
        
        for (int i = 0; i < cores.length; i++) {
            
            if (time % cores[i] == 0) {
                remain--;
                
                if (remain == 0) {
                    return i + 1;
                }
            }
        }
        
        return -1;
    }
}