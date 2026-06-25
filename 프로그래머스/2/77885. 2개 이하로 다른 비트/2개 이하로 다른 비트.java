class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        
        
        for(int i = 0; i < numbers.length; i++){
            long now = numbers[i];
            if(now%2 == 0) answer[i] = now+1;
            else {
                
                String tmp = "0" + Long.toBinaryString(now);
                char[] arr = tmp.toCharArray();

                for (int j = arr.length - 2; j >= 0; j--) {
                    if (arr[j] == '0' && arr[j + 1] == '1') {
                        arr[j] = '1';
                        arr[j + 1] = '0';
                        break;
                    }
                }

                answer[i] = Long.parseLong(new String(arr), 2);
                
            }
            
        }
        
        return answer;
    }
}