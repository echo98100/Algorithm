class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int[] answer = new int[2];
        int aliceSum = 0;
        int bobSum = 0;

        for(int n : aliceSizes){
            aliceSum += n;
        }
        for(int n : bobSizes){
            bobSum += n;
        }

        // aliceSum - alice + bob = bobSum - bob + alice
        // aliceSum - bobSum = 2(alice - bob)
        // 각 alice에 대해서 만족하는 bob이 bobSizes 안에 있는지 확인 
        // bob = alice - (aliceSum - bobSum)/2
        loop:
        for (int alice : aliceSizes) {

            int temp = alice - (aliceSum - bobSum)/2;

            for(int bob : bobSizes) {
                if(temp == bob) {
                    answer[0] = alice;
                    answer[1] = bob;
                    break loop;
                }
            }

        }
        
        return answer;
    }
}