class Solution {
    public boolean canJump(int[] nums) {
        int maxReachablePosition = 0;

        for(int i = 0; i < nums.length; i++) {
            if(i > maxReachablePosition) {
                return false;
            }
            maxReachablePosition = Math.max(maxReachablePosition, i + nums[i]);
        }

        return maxReachablePosition >= nums.length - 1;
    }
}
