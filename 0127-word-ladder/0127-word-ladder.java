class Solution {
    // shortest transformation-- bfs
    // build graph: 马冬梅 => *冬梅，马*梅，马东*
    HashMap<String, Integer> wordToId = new HashMap();
    ArrayList<ArrayList<Integer>> graph = new ArrayList();
    // label word from 0
    int wordId = 0;
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;
        // build graph
        for (String word : wordList) {
            addEdge(word);
        }
        addEdge(beginWord);
        // if (!wordToId.containsKey(endWord)) return 0;
        // distance[i] is the status change # from beginWord to i
        // word => vague word => word
        // wordId is the # of nodes
        int[] distance = new int[wordId];
        Arrays.fill(distance, Integer.MAX_VALUE);
        int beginId = wordToId.get(beginWord), endId = wordToId.get(endWord);
        distance[beginId] = 0;
        // BFS
        ArrayDeque<Integer> q = new ArrayDeque();
        q.offer(beginId);
        
        while (!q.isEmpty()) {
            int curr = q.poll();
            // return # of nodes of the trans seq, so +1
            if (curr == endId) return distance[endId] / 2 + 1;
            ArrayList<Integer> neighbors = graph.get(curr);
            for (int neighbor : neighbors) {
                // if not visited
                if (distance[neighbor] == Integer.MAX_VALUE) {
                    q.offer(neighbor);
                    distance[neighbor] = distance[curr] + 1;
                }
            }
        }
        return 0;
    }
    
    public void addEdge(String word) {
        addWord(word);
        char[] array = word.toCharArray();
        int id1 = wordToId.get(word);
        // build dummy nodes, and connect edge
        for (int i = 0; i < word.length(); ++i) {
            char temp = array[i];
            array[i] = '*';
            String newWord = new String(array);
            addWord(newWord);
            int id2 = wordToId.get(newWord);
            graph.get(id1).add(id2);
            graph.get(id2).add(id1);
            array[i] = temp;
        }
        
    }
    
    public void addWord(String word) {
        if (!wordToId.containsKey(word)) {
            wordToId.put(word, wordId++);
            graph.add(new ArrayList<Integer>());
        }        
    }
}