class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Integer> maxTemp = new Stack<>();

        for(int i = temperatures.length - 1; i >= 0; i--) {
            if(maxTemp.isEmpty()) {
                result[i] = 0;
                maxTemp.add(i);
            } else {
                while(!maxTemp.isEmpty() && temperatures[maxTemp.peek()] <= temperatures[i]) {
                    maxTemp.pop();
                }

                result[i] = maxTemp.isEmpty() ? 0 : maxTemp.peek() - i;
                maxTemp.add(i);
            }
        }

        return result;
    }
}

// [30, 38, 30,36, 35, 40, 28]
// 28
// 40
// 40 35
// 40 36
// 40 36 30
// 40 38
// 40 38 30