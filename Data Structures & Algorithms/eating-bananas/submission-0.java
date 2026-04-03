class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxK = piles[0];
        int minK = Integer.MAX_VALUE;

        for(int i = 1; i < piles.length; i++) {
            maxK = Math.max(maxK, piles[i]);
        }

        int start = 1;
        int end = maxK;

        while(start <= end) {
            int mid = (start + end) / 2;
            int hours = 0;
            for(int i = 0; i < piles.length; i++) {
                hours += Math.ceil(piles[i]/(1.0 * mid));
            }

            if(hours <= h) {
                minK = Math.min(minK, mid);
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return minK;
    }
}
