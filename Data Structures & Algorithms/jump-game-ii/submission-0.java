class Solution {
    public int jump(int[] nums) {
        int[] numSteps = new int[nums.length];
        Arrays.fill(numSteps, Integer.MAX_VALUE);
        numSteps[0] = 0;

        for(int i = 0; i < nums.length; i++) {
            if(numSteps[i] != Integer.MAX_VALUE) {
                for(int j = i + 1; j <= i + nums[i] && j < nums.length; j++) {
                    numSteps[j] = Math.min(numSteps[j], numSteps[i] + 1);
                }
                System.out.println(numSteps[i]);
            }

            if(numSteps[nums.length - 1] != Integer.MAX_VALUE){
                break;
            }
        }

        return numSteps[nums.length - 1];
    }
}
