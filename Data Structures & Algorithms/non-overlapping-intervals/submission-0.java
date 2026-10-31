class Solution {
    // Time Complexity: O(nlogn)
    // Space Complexity: O(1)
    public int eraseOverlapIntervals(int[][] intervals) {
        int[] prev = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        int minIntervals = 0;

        Arrays.sort(intervals, (a, b) -> {
            return Integer.compare(a[0], b[0]);
        });

        for(int i = 0; i < intervals.length; i++) {
            if(prev[0] == Integer.MAX_VALUE) {
                prev = intervals[i];
            } else {
                if(intervals[i][0] < prev[1]) {
                    if(prev[1] > intervals[i][1]) {
                        prev = intervals[i];
                    }
                    minIntervals++;
                } else {
                    prev = intervals[i];
                }
            }
        }

        return minIntervals;
    }
}