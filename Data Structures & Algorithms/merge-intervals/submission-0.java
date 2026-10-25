class Solution {

    // Time Complexity: O(nlogn)
    // Space Complexity: O(n)
    public int[][] merge(int[][] intervals) {
        Stack<int[]> mergeStack = new Stack<>();
        List<int[]> mergedIntervals = new ArrayList<>();

        Arrays.sort(intervals, (a, b) -> {
            return a[0] - b[0];
        });
        
        for(int i = 0; i < intervals.length; i++) {
            if(mergeStack.isEmpty()) {
                mergeStack.add(intervals[i]);
            } else {
                int[] lastInterval = mergeStack.peek();

                if((intervals[i][0] >= lastInterval[0] && intervals[i][0] <= lastInterval[1]) || 
                (lastInterval[0] >= intervals[i][0] && lastInterval[0] <= intervals[i][1])) {
                    mergeStack.pop();
                    mergeStack.push(new int[]{
                        Math.min(intervals[i][0], lastInterval[0]),
                        Math.max(intervals[i][1], lastInterval[1])
                    });
                } else {
                    mergeStack.add(intervals[i]);
                }
            }
        }

        for(int[] mergedInterval: mergeStack) {
            mergedIntervals.add(mergedInterval);
        }

        return mergedIntervals.toArray(new int[0][]);
    }
}

