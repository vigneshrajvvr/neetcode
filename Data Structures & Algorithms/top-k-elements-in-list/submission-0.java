class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> frequency = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            frequency.put(nums[i], frequency.getOrDefault(nums[i], 0) + 1);
        }

        PriorityQueue<Pair> topKFrequent = new PriorityQueue<>((a, b) -> {
            return a.count - b.count;
        });

        for(Map.Entry<Integer, Integer> entries : frequency.entrySet()) {
            topKFrequent.add(new Pair(entries.getKey(), entries.getValue()));
            if(topKFrequent.size() > k) {
                topKFrequent.remove();
            }
        }

        int[] result = new int[topKFrequent.size()];
        int index = 0;
        for(Pair currentPair : topKFrequent) {
            result[index++] = currentPair.value;
        }

        return result;
    }
}


public class Pair {
    public int value;
    public int count;

    public Pair(int value, int count) {
        this.value = value;
        this.count = count;
    }
}
