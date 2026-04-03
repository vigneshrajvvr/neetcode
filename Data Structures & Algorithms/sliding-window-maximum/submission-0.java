class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new LinkedList<>();
        int result[] = new int[nums.length - k + 1];
        int resultIndex = 0;

        for(int i = 0; i < k; i++) {
            while(!deque.isEmpty() && nums[deque.getLast()] < nums[i]) {
                deque.removeLast();
            }
            deque.addLast(i);
        }

        result[resultIndex++] = nums[deque.getFirst()];

        int pointer1 = 1;
        int pointer2 = k;

        while(pointer2 < nums.length) {
            if(!deque.isEmpty() && deque.getFirst() == pointer1 - 1) {
                deque.removeFirst();
            }

            while(!deque.isEmpty() && nums[deque.getLast()] < nums[pointer2]) {
                deque.removeLast();
            }
            deque.addLast(pointer2);

            result[resultIndex++] = nums[deque.getFirst()];
            pointer1++;
            pointer2++;
        }

        return result;
    }
}
