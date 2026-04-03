class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for(int i = 0; i < nums.length; i++) {
            if(i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int start = i + 1;
            int end = nums.length - 1;

            while(start < end) {
                if(end < nums.length - 1 && nums[end] == nums[end + 1]) {
                    end--;
                    continue;
                }
                if(nums[start] + nums[end] == -nums[i]) {
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(nums[start]);
                    temp.add(nums[end]);
                    temp.add(nums[i]);
                    Collections.sort(temp);
                    result.add(temp);
                    start++;
                    end--;
                } else if(nums[start] + nums[end] < -nums[i]) {
                    start++;
                } else {
                    end--;
                }
            }
        }

        return result;
    }
}
