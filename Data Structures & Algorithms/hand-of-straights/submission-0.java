class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0) {
            return false;
        }

        HashMap<Integer, Integer> frequency = new HashMap<>();

        for(int i = 0; i < hand.length; i++) {
            frequency.put(hand[i], frequency.getOrDefault(hand[i], 0) + 1);
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(frequency.keySet());

        while(!minHeap.isEmpty()) {
            int minValue = minHeap.peek();
            for(int i = 0; i < groupSize; i++) {
                if(!frequency.containsKey(minValue + i)) {
                    return false;
                }
                
                frequency.put(minValue + i, frequency.get(minValue + i) - 1);
                if(frequency.get(minValue + i) == 0) {
                    frequency.remove(minValue + i);
                    if(minValue + i == minHeap.peek()) {
                        minHeap.remove();
                    } else {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
