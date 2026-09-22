class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);

        int left = 1;
        int right = piles[piles.length-1];

        while(left < right) {

            int mid = (left+right)/2;

            int sum = 0;

            for(int pile : piles) {

                if(pile%mid == 0) sum += (pile/mid);
                else sum += (pile/mid)+1;

                if(sum > h) break;
                    
            }
            // 더 빨리 먹어야함
            if(sum > h) left = mid+1;
            // 더 천천히 먹을 수 있다
            else right = mid;

        }
        // 결국 left = right 되는 순간을 찾아야함
        return left;
    }
}