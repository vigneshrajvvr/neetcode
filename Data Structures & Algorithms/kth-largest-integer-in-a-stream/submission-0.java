class KthLargest {
    PriorityQueue<Integer> kthOrder;
    int k;

    public KthLargest(int k, int[] nums) {
        kthOrder = new PriorityQueue<>();
        this.k = k;

        for(int i = 0; i < nums.length; i++) {
            kthOrder.add(nums[i]);
            if(kthOrder.size() > k) {
                kthOrder.remove();
            }
        }  
    }
    
    public int add(int val) {
        kthOrder.add(val);
        if(kthOrder.size() > k) {
            kthOrder.remove();
        }

        return kthOrder.peek();
    }
}
