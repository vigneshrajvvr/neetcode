class Solution {
    // Time Complexity: O(n)
    // Space Complexity: O(1), if we consider output list, then O(n)
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> mergedIntervals = new ArrayList<>();

        for(int i = 0; i < intervals.length; i++) {
            if(newInterval[1] < intervals[i][0]) {
                mergedIntervals.add(newInterval);
                for(int j = i; j < intervals.length; j++) {
                    mergedIntervals.add(intervals[j]);
                }

                return mergedIntervals.toArray(new int[0][]);
            } else if(newInterval[0] > intervals[i][1]) {
                mergedIntervals.add(intervals[i]);
            } else {
                newInterval = new int[]{
                    Math.min(intervals[i][0], newInterval[0]),
                    Math.max(intervals[i][1], newInterval[1])
                };
            }
        }

        mergedIntervals.add(newInterval);

        return mergedIntervals.toArray(new int[0][]);
    }
}