class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> leftStack = new Stack<>();
        int[] leftMin = new int[heights.length];
        int largestRectangle = Integer.MIN_VALUE;

        for(int i = 0; i < heights.length; i++) {
            while(!leftStack.isEmpty() && heights[i] <= heights[leftStack.peek()]) {
                leftStack.pop();
            }

            leftMin[i] = leftStack.isEmpty() ? -1 : leftStack.peek();
            leftStack.add(i);
        } 

        Stack<Integer> rightStack = new Stack<>();
        int[] rightMin = new int[heights.length];

        for(int i = heights.length - 1; i >= 0; i--) {
            while(!rightStack.isEmpty() && heights[i] <= heights[rightStack.peek()]) {
                rightStack.pop();
            }

            rightMin[i] = rightStack.isEmpty() ? heights.length : rightStack.peek();
            rightStack.add(i);
        } 

        for(int i = 0; i < heights.length; i++) {
            largestRectangle = Math.max(largestRectangle, heights[i] * (rightMin[i] - leftMin[i] - 1));
        }

        return largestRectangle;
    }
}

// [2,1,1,5,1,2]
// [1,1,2,2,2,3]