class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // Start from the maximum possible gas (sum of the gases)
        if(sum(gas) < sum(cost)) {
            return -1;
        }

        int index = 0;
        int totalGas = 0;

        for(int i = 0; i < gas.length; i++) {
            totalGas += (gas[i] - cost[i]);

            if(totalGas < 0) {
                totalGas = 0;
                index = i + 1;
            }
        }

        return index;
    }

    private int sum(int[] values) {
        int sum = 0;
        for(int i : values) {
            sum += i;
        }

        return sum;
    }
}
