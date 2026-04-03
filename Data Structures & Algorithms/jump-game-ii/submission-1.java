class Solution {
    public int jump(int[] nums) {
        int start = 0;
        int end = 0;
        int jumps = 0;

        if(nums.length == 1) {
            return 0;
        }

        while(end < nums.length) {
            int farthest = 0;
            for(int i = start; i <= end; i++) {
                farthest = Math.max(i + nums[i], farthest);
            }
            start = end + 1;
            end = farthest;
            jumps++;

            if(farthest >= nums.length - 1) {
                break;
            }
        }

        return jumps;
    }
}
