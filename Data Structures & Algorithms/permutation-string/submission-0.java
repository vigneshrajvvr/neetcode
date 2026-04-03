class Solution {
    public boolean checkInclusion(String s1, String s2) {
                int[] s1Chars = new int[26];
        int[] s2Chars = new int[26];

        if(s2.length() < s1.length()) {
            return false;
        }

        for(int i = 0; i < s1.length(); i++) {
            s1Chars[s1.charAt(i) - 'a']++;
            s2Chars[s2.charAt(i) - 'a']++;
        }

        boolean inclusion = true;
        for(int i = 0; i < 26; i++) {
            if(s1Chars[i] != s2Chars[i]) {
                inclusion = false;
                break;
            }
        }

        if(inclusion) {
            return true;
        }

        int pointer1 = 0;
        int pointer2 = s1.length();

        while(pointer2 < s2.length()) {
            s2Chars[s2.charAt(pointer1) - 'a']--;
            s2Chars[s2.charAt(pointer2) - 'a']++;
            pointer1++;
            pointer2++;

            inclusion = true;
            for(int i = 0; i < 26; i++) {
                if(s1Chars[i] != s2Chars[i]) {
                    inclusion = false;
                    break;
                }
            }

            if(inclusion) {
                return true;
            }
        }

        return false;
    }
}
