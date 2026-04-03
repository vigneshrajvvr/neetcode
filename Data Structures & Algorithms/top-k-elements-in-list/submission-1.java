class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> frequency = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            frequency.put(nums[i], frequency.getOrDefault(nums[i], 0) + 1);
        }

        PriorityQueue<Integer> topKFrequent = new PriorityQueue<>((a, b) -> {
            return frequency.get(a) - frequency.get(b);
        });

        for(Map.Entry<Integer, Integer> entries : frequency.entrySet()) {
            topKFrequent.add(entries.getKey());
            if(topKFrequent.size() > k) {
                topKFrequent.remove();
            }
        }

        int[] result = new int[topKFrequent.size()];
        int index = 0;
        for(Integer currentPair : topKFrequent) {
            result[index++] = currentPair;
        }

        return result;
    }
}

