class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        
        int longest = 1;
        Arrays.sort(nums);
        int temp = 1;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] != nums[i - 1]) {
                if(nums[i - 1] + 1 == nums[i]) {
                    temp++;
                } else {
                    longest = Math.max(temp, longest);
                    temp = 1;
                }
            }
        }

        longest = Math.max(temp, longest);

        return longest;
    }
}
