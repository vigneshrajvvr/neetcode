class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        Stack<int[]> stack = new Stack<>();
        List<int[]> intervalsResult = new ArrayList<>();
        boolean isNewIntervalUsed = false;
        
        if(intervals.length == 0) {
            return new int[][]{newInterval};
        }

        for(int i = 0; i < intervals.length; i++) {
            int[] intervalToBeInserted = intervals[i];
            if(!isNewIntervalUsed && 
            newInterval[0] >= intervals[i][0] && newInterval[0] <= intervals[i][1] ||
            intervals[i][0] >= newInterval[0] && intervals[i][0] <= newInterval[1]) {
                intervalToBeInserted = new int[] {Math.min(newInterval[0], intervals[i][0]), Math.max(newInterval[1], intervals[i][1])};
                isNewIntervalUsed = true;
            }
            if(stack.isEmpty()) {
                stack.add(intervalToBeInserted);
            } else {
                if(intervalToBeInserted[0] >= stack.peek()[0] && intervalToBeInserted[0] <= stack.peek()[1] ||
                stack.peek()[0] >= intervalToBeInserted[0] && stack.peek()[0] <= intervalToBeInserted[1]) {
                    int[] bindedInterval = new int[] {Math.min(intervalToBeInserted[0], stack.peek()[0]), Math.max(stack.peek()[1], intervalToBeInserted[1])};
                    stack.pop();
                    stack.push(bindedInterval);
                } else {
                    stack.add(intervalToBeInserted);
                }
            }
        }   

        for(int[] intervalsList : stack) {
            intervalsResult.add(intervalsList);
        }

        if(!isNewIntervalUsed) {
            for(int i = 0; i < intervalsResult.size(); i++) {
                if(intervalsResult.get(i)[0] > newInterval[0]) {
                    intervalsResult.add(i, newInterval);
                    isNewIntervalUsed = true;
                    break;
                }
            }
        }

        if(!isNewIntervalUsed) {
            intervalsResult.add(newInterval);
        }

        return intervalsResult.toArray(new int[0][]);
    }
}