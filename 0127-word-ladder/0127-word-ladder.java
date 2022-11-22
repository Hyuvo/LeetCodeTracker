class Solution {
    // bfs
    // use vague layers to connect words
    // use bidirect bfs to optimize
    
    // label words with id
    HashMap<String, Integer> wordToId = new HashMap();
    // graph without knowing size
    ArrayList<ArrayList<Integer>> graph = new ArrayList();
    // also the # of nodes
    int wordId = 0;
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // no such an endWord
        if (!wordList.contains(endWord)) return 0;
        // build graph
        for (String word : wordList) {
            addEdge(word);
        }
        addEdge(beginWord);
        // wordId is also the # of nodes(including vague nodes)
        // steps[i] is the # of steps from beginWord to i
        int[] steps = new int[wordId];
        // total steps < wordId(# of nodes)
        Arrays.fill(steps, wordId);       
        int beginId = wordToId.get(beginWord), endId = wordToId.get(endWord);
        steps[beginId] = 0;
        // bfs
        ArrayDeque<Integer> q = new ArrayDeque();
        q.offer(beginId);
        while (!q.isEmpty()) {
            int curr = q.poll();
            // reach target
            // # of words = steps + 1
            // devided by 2 because of vague layers
            if (curr == endId) return steps[endId] / 2 + 1;
            for (int next : graph.get(curr)) {
                // if not visited
                if (steps[next] == wordId) {
                    steps[next] = steps[curr] + 1;
                    q.offer(next);
                }
            }
        }
        return 0;
    }
    
    // connect nodes through vague words in the middle
    private void addEdge(String word) {
        addWord(word);
        // create vague words and connect
        char[] array = word.toCharArray();
        int id1 = wordToId.get(word);
        for (int i = 0; i < array.length; ++i) {
            char temp = array[i];
            // create vague nodes
            array[i] = '*';
            String newWord = new String(array);           
            addWord(newWord);
            int id2 = wordToId.get(newWord);
            // connect
            graph.get(id1).add(id2);
            graph.get(id2).add(id1);
            array[i] = temp;
        }
    }
    
    private void addWord(String word) {
        if (!wordToId.containsKey(word)) {
            wordToId.put(word, wordId++);
            // increase graph size accordingly
            graph.add(new ArrayList<>());
        }
    }
    
}