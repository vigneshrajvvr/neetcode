class MedianFinder {
    private PriorityQueue<Integer> minHeap;
    private PriorityQueue<Integer> maxHeap;

    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        maxHeap.add(num);

        if(maxHeap.size() > minHeap.size() + 1) {
            minHeap.add(maxHeap.remove());
        }

        if(!maxHeap.isEmpty() && !minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()) {
            int temp = minHeap.remove();
            minHeap.add(maxHeap.remove());
            maxHeap.add(temp);
        }
    }
    
    public double findMedian() {
        int size = maxHeap.size() + minHeap.size();
        if(size % 2 == 0) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        } else {
            return (double) maxHeap.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */

 // MaxHeap           MinHeap
 // 1   2 3             4  5                  