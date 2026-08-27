class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!isEndWordInWordList(wordList, endWord)) {
            return 0;
        }

        if(beginWord.equals(endWord)) {
            return 0;
        }

        // Extract the pattern for each word in the list including beginWord
        Map<String, List<String>> patterns = new HashMap<>();
        extractPatterns(patterns, beginWord);
        for(String word : wordList) {
            extractPatterns(patterns, word);
        }

        // Generate Adjaceny Map
        Map<String, List<String>> adjMap = new HashMap<>();
        populateAdjMap(adjMap, patterns, beginWord);
        for(String word : wordList) {
            populateAdjMap(adjMap, patterns, word);
        }
        
        return bfs(adjMap, beginWord, endWord);
    }

    private int bfs(Map<String, List<String>> adjMap, String beginWord, String endWord) {
        int shortestPath = 1;
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        visited.add(beginWord);

        while(!queue.isEmpty()) {
            shortestPath++;
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                String currentWord = queue.remove();
                List<String> neighbours = adjMap.get(currentWord);
                for(String neighbour : neighbours) {
                    if(neighbour.equals(endWord)) {
                        return shortestPath;
                    }

                    if(!visited.contains(neighbour)) {
                        visited.add(neighbour);
                        queue.add(neighbour);
                    }
                }
            }
        }

        return 0;
    }

    private void populateAdjMap(Map<String, List<String>> adjMap, Map<String, List<String>> patterns, String word) {
        for(int i = 0; i < word.length(); i++) {
            String pattern = word.substring(0, i) + "*" + word.substring(i + 1, word.length());
            if(!adjMap.containsKey(word)) {
                adjMap.put(word, new ArrayList<>());
            }
            adjMap.get(word).addAll(patterns.get(pattern));
        }
    }

    private void extractPatterns(Map<String, List<String>> patterns, String word) {
        for(int i = 0; i < word.length(); i++) {
            String pattern = word.substring(0, i) + "*" + word.substring(i + 1, word.length());
            if(!patterns.containsKey(pattern)) {
                patterns.put(pattern, new ArrayList<>());
            }
            patterns.get(pattern).add(word);
        }
    }

    private boolean isEndWordInWordList(List<String> wordList, String endWord) {
        for(String words : wordList) {
            if(endWord.equals(words)) {
                return true;
            }
        }
        return false;
    }
}

/* 
- Generate a graph with node as each word and edge as the words which are differing by only one character.
beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]

hit -> hot
hot -> dot, lot, log
dot -> hot, dog, lot
dog -> dot, log, cog
lot -> hot, dot
log -> dog, lot, cog
cog -> dog, log

- Finding the words which are differing by only one character.


*/