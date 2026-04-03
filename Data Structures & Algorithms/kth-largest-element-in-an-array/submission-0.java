class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> values = new PriorityQueue<>();

        for(int i = 0; i < nums.length; i++) {
            values.offer(nums[i]);
            if(values.size() > k) {
                values.poll();
            }
        }

        return values.peek();
    }
}
