class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> evaluations = new Stack<>();

        for(int i = 0; i < tokens.length; i++) {
            if(tokens[i].equals("+")) {
                int nums2 = evaluations.pop();
                int nums1 = evaluations.pop();
                evaluations.push(nums1 + nums2);
            } else if(tokens[i].equals("-")) {
                int nums2 = evaluations.pop();
                int nums1 = evaluations.pop();
                evaluations.push(nums1 - nums2);
            } else if(tokens[i].equals("/")) {
                int nums2 = evaluations.pop();
                int nums1 = evaluations.pop();
                evaluations.push(nums1 / nums2);
            } else if(tokens[i].equals("*")) {
                int nums2 = evaluations.pop();
                int nums1 = evaluations.pop();
                evaluations.push(nums1 * nums2);
            } 
            else {
                evaluations.add(Integer.valueOf(tokens[i]));
            }
        }

        return evaluations.peek();
    }
}
