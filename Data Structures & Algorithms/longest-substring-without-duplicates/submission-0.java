class Solution {
    public int lengthOfLongestSubstring(String s) {
                int maxLength = 0;
        int pointer1 = 0;
        int pointer2 = 0;
        HashSet<Character> values = new HashSet<>();

        while(pointer2 < s.length()) {
            while(!values.add(s.charAt(pointer2))) {
                values.remove(s.charAt(pointer1));
                pointer1++;
            }

            maxLength = Math.max(maxLength, pointer2 - pointer1 + 1);
            pointer2++;
        }

        return maxLength;
    }
}
