class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> groupedAnagrams = new HashMap<>();

        for(String currentString : strs) {
            char[] stringArray = currentString.toCharArray();
            Arrays.sort(stringArray);
            String sortedString = String.valueOf(stringArray);
            if(!groupedAnagrams.containsKey(sortedString)) {
                groupedAnagrams.put(sortedString, new ArrayList<>());
            }
            groupedAnagrams.get(sortedString).add(currentString);
        }

        return new ArrayList<>(groupedAnagrams.values());
    }
}
