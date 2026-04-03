class Solution {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int minElement = Integer.MAX_VALUE;

        while(start <= end) {
            int mid = (start + end) / 2;

            minElement = Math.min(minElement, nums[mid]);

            if(nums[start] <= nums[end]) {
                minElement = Math.min(minElement, nums[start]);
                break;
            } else if(nums[mid] >= nums[start]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return minElement;
    }
}