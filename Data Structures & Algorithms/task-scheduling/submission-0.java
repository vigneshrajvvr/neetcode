class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        PriorityQueue<Integer> taskFrequency = new PriorityQueue<>(Collections.reverseOrder());
        Deque<int[]> scheduler = new LinkedList<>();
        int time = 0;

        for(int i = 0; i < tasks.length; i++) {
            count[tasks[i] - 'A']++;
        }

        for(int i = 0; i < 26; i++) {
            if(count[i] != 0) {
                taskFrequency.add(count[i]);
            }
        }

        while(!taskFrequency.isEmpty() || !scheduler.isEmpty()) {
            time++;

            if(!taskFrequency.isEmpty()) {
                int currentTask = taskFrequency.remove() - 1;
                if(currentTask != 0) {
                    scheduler.addLast(new int[]{currentTask, time + n});
                }
            }

            if(!scheduler.isEmpty() && time == scheduler.peek()[1]) {
                taskFrequency.add(scheduler.removeFirst()[0]);
            }
        }

        return time;
    }
}
