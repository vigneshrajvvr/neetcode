/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {

    // Time Complexity: O(nlogn)
    // Space Complexity: O(1)
    public boolean canAttendMeetings(List<Interval> intervals) {
        Interval prev = null;
        Collections.sort(intervals, (a, b) -> {
            return Integer.compare(a.start, b.start);
        });

        for(int i = 0; i < intervals.size(); i++) {
            if(prev == null) {
                prev = intervals.get(i);
            } else {
                if(intervals.get(i).start < prev.end) {
                    return false;
                }

                prev = intervals.get(i);
            }
        }

        return true;
    }
}
