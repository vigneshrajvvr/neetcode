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
    // Space Complexity: O(n)
    public int minMeetingRooms(List<Interval> intervals) {
        PriorityQueue<Interval> result = new PriorityQueue<>((a, b) ->      {
            return Integer.compare(a.end, b.end);
        });
        Collections.sort(intervals, (a, b) -> {
            return Integer.compare(a.start, b.start);
        });

        for(int i = 0; i < intervals.size(); i++) {
            if(result.isEmpty()) {
                result.add(intervals.get(i));
            } else {
                if(result.peek().end <= intervals.get(i).start) {
                    result.remove();
                }
                result.add(intervals.get(i));
            }
        }

        return result.size();
    }
}
