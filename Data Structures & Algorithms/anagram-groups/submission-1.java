class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> groupedAnagrams = new HashMap<>();
        for(String currentString : strs) {
            int[] count = new int[26];
            for(int i = 0; i < currentString.length(); i++) {
                count[currentString.charAt(i) - 'a']++;
            }

            StringBuilder convertedString = new StringBuilder();
            for(int i = 0; i < 26; i++) {
                if(count[i] > 0) {
                    convertedString.append(count[i]);
                    convertedString.append((char)(i - 'a'));
                }
            }

            if(!groupedAnagrams.containsKey(convertedString.toString())) {
                groupedAnagrams.put(convertedString.toString(), new ArrayList<>());
            }

            groupedAnagrams.get(convertedString.toString()).add(currentString);
        }

        return new ArrayList<>(groupedAnagrams.values());
    }
}
