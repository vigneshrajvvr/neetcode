class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> duplicates = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
            if(!duplicates.add(nums[i])) {
                return true;
            }
        }

        return false;
    }
}
