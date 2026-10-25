class Solution {

    // Time Complexity: O(nlogn)
    // Space Complexity: O(1)
    public int[][] merge(int[][] intervals) {
        int[] tempInterval = new int[]{-1, -1};
        List<int[]> mergedIntervals = new ArrayList<>();

        Arrays.sort(intervals, (a, b) -> {
            return a[0] - b[0];
        });

        for(int i = 0; i < intervals.length; i++) {
            if(tempInterval[0] == -1) {
                tempInterval = intervals[i];
            } else {
                if((intervals[i][0] >= tempInterval[0] && intervals[i][0] <= tempInterval[1]) ||
                (tempInterval[0] >= intervals[i][0] && tempInterval[0] <= intervals[i][1])) {
                    tempInterval[0] = Math.min(tempInterval[0], intervals[i][0]);
                    tempInterval[1] = Math.max(tempInterval[1], intervals[i][1]);
                } else {
                    mergedIntervals.add(tempInterval);
                    tempInterval = intervals[i];
                }
            }
        }        

        mergedIntervals.add(tempInterval);

        return mergedIntervals.toArray(new int[0][]);
    }
}

// [1 , 3]
// Result: []

// [1, 6]
// Result: []

// [8, 10]
// Result: [[1, 6]]

// [15, 18]
// Result: [[1, 6], [8, 10]]

// Result: [[1, 6], [8, 10]]

