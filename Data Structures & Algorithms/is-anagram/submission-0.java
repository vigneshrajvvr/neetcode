class Solution {
    public boolean isAnagram(String s, String t) {
        char[] counter = new char[26];
        if(s.length() != t.length()) {
            return false;
        }

        for(int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }

        for(int value : counter) {
            if(value != 0) {
                return false;
            }
        }

        return true;
    }
}
