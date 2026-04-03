class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> values = new HashSet<>();
        for(int value : nums) {
            values.add(value);
        }

        int lc = 0;
        // TC: O(2 * N)
        // SC: O(N)
        for(int num : values) {
            if(!values.contains(num - 1)) {
                int temp = 1;
                int tempValue = num;
                while(values.contains(tempValue + 1)) {
                    temp++;
                    tempValue++;
                } 
                lc = Math.max(lc, temp);
            }
        }

        return lc;
    }
}
