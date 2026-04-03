class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> values = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            if(values.containsKey(target - nums[i])) {
                return new int[] {values.get(target - nums[i]), i};
            }
            values.put(nums[i], i);
        }

        return new int[] {-1, -1};
    }
}
