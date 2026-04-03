class Solution {
    public String minWindow(String s, String t) {
        int resultStart = -1;
        int resultEnd = -1;
        int resultLength = Integer.MAX_VALUE;
        int pointer1 = 0;
        int pointer2 = 0;
        int matchingUniqueChars = 0;
        HashMap<Character, Integer> sChars = new HashMap<>();
        HashMap<Character, Integer> tChars = new HashMap<>();

        for(char currentChar : t.toCharArray()) {
            tChars.put(currentChar, tChars.getOrDefault(currentChar, 0) + 1);
        }

        while(pointer2 < s.length()) {
            if(tChars.containsKey(s.charAt(pointer2))) {
                sChars.put(s.charAt(pointer2), sChars.getOrDefault(s.charAt(pointer2), 0) + 1);

                if(sChars.get(s.charAt(pointer2)).equals(tChars.get(s.charAt(pointer2)))) {
                    matchingUniqueChars++;
                }

                while(matchingUniqueChars == tChars.size()) {
                    if((pointer2 - pointer1 + 1) < resultLength) {
                        resultStart = pointer1;
                        resultEnd = pointer2;
                        resultLength = pointer2 - pointer1 + 1;
                    }

                    if(sChars.containsKey(s.charAt(pointer1))) {
                        if (sChars.get(s.charAt(pointer1)).equals(tChars.get(s.charAt(pointer1)))) {
                            matchingUniqueChars--;
                        }
                        sChars.put(s.charAt(pointer1), sChars.get(s.charAt(pointer1)) - 1);
                    }  
                    pointer1++;
                }
            }
            pointer2++;
        }

        return resultLength == Integer.MAX_VALUE ? "" : s.substring(resultStart, resultEnd + 1);
    }
}
