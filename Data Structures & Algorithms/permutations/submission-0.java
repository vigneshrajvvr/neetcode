class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();

        generatePermutations(nums, 0, permutations);

        return permutations;
    }

    private void generatePermutations(int[] nums, int index, List<List<Integer>> permutations) {
        if(index == nums.length) {
            List<Integer> list = new ArrayList<>();
            for(int num : nums) {
                list.add(num);
            }
            permutations.add(list);
            return;
        }

        for(int i = index; i < nums.length; i++) {
            swap(i, index, nums);
            generatePermutations(nums, index + 1, permutations);
            swap(i, index, nums);
        }
    }

    private void swap(int index1, int index2, int[] nums) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}