class Solution {
    public int characterReplacement(String s, int k) {
        int maxLength = 0;
        int [] letters = new int[26];
        int pointer1 = 0;
        int pointer2 = 0;
        int maxCharacters = 0;

        while(pointer2 < s.length()) {
            letters[s.charAt(pointer2) - 'A']++;
            maxCharacters = Math.max(letters[s.charAt(pointer2) - 'A'], maxCharacters);
            int changes = (pointer2 - pointer1 + 1) - maxCharacters;

            if(changes > k) {
                letters[s.charAt(pointer1) - 'A']--;
                pointer1++;
            }

            maxLength = Math.max(maxLength, pointer2 - pointer1 + 1);
            pointer2++;
        }

        return maxLength;
    }
}
