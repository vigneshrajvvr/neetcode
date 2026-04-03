class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> partitions = new ArrayList<>();

        int left = 0;
        int right = 0;
        for(int i = 0; i < s.length(); i++) {
            for(int j = i + 1; j < s.length(); j++) {
                if(s.charAt(i) == s.charAt(j)) {
                    right = Math.max(right, j);
                }
            }


            if(right == i) {
                partitions.add(right - left + 1);
                left = i + 1;
                right = i + 1;
            }
        }

        return partitions;
    }
}
