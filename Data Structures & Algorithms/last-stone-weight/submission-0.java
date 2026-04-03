class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> lastStone = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i < stones.length; i++) {
            lastStone.offer(stones[i]);
        }

        while(lastStone.size() >= 2) {
            int stone1 = lastStone.poll();
            int stone2 = lastStone.poll();
            int absValue = Math.abs(stone2 - stone1);

            if(absValue != 0) {
                lastStone.add(absValue);
            }
        }

        return lastStone.isEmpty() ? 0 : lastStone.peek();
    }
}
