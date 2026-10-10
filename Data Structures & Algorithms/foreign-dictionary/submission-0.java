class Solution {
    public String foreignDictionary(String[] words) {
      Map<Character, HashSet<Character>> adjList = new HashMap<>();
        Map<Character, Integer> charCount = new HashMap<>();
        Queue<Character> dfs = new LinkedList<>();
        StringBuilder result = new StringBuilder();

        // Initialize adjList and indegree
        for(int i = 0; i < words.length; i++) {
            for(int j = 0; j < words[i].length(); j++) {
                adjList.put(words[i].charAt(j), new HashSet<>());
                charCount.put(words[i].charAt(j), 0);
            }
        }

        // Construct the nodes and update the indegree
        for(int i = 1; i < words.length; i++) {
            String word1 = words[i - 1];
            String word2 = words[i];
            int pointer1 = 0;
            int pointer2 = 0;

            if(word1.length() > word2.length() && word1.startsWith(word2)) {
                return "";
            }

            while(pointer1 < word1.length() && pointer2 < word2.length()) {
                if(word1.charAt(pointer1) != word2.charAt(pointer2)) {
                    if(adjList.get(word1.charAt(pointer1)).add(word2.charAt(pointer2))) {
                        charCount.put(word2.charAt(pointer2), charCount.get(word2.charAt(pointer2)) + 1);
                    }
                    break;
                }
                pointer1++;
                pointer2++;
            }
        }

        // Update the queue
        for(Map.Entry<Character, Integer> keyValue : charCount.entrySet()) {
            if(keyValue.getValue() == 0) {
                dfs.add(keyValue.getKey());
            }
        }

        while(!dfs.isEmpty()) {
            char value = dfs.remove();
            result.append(value);
            if(adjList.containsKey(value)) {
                HashSet<Character> neighbours = adjList.get(value);
                for(char neighbour : neighbours) {
                    charCount.put(neighbour, charCount.get(neighbour) - 1);
                    if(charCount.get(neighbour) == 0) {
                        dfs.add(neighbour);
                    }
                }
            }
        }

        for(Map.Entry<Character, Integer> keyValue : charCount.entrySet()) {
            if(keyValue.getValue() != 0) {
                return "";
            }
        }

        return result.toString();
    }
}
