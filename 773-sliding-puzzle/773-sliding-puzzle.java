class Solution {
    public int slidingPuzzle(int[][] board) {
        int m = 2, n = 3;
        StringBuilder sb = new StringBuilder();
        String target = "123450";
        // reduct the 2-d array to 1-d
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(board[i][j]);
            }
        }
        String start = sb.toString();
        
        // track the orginal neighbors' indexes in 1-d array
        // neighbors[i] is the 2-d neighbors' index in 1-d array
        int[][] neighbors = new int[][] {
            {1, 3},
            {0, 2, 4},
            {1, 5},
            {0, 4},
            {1, 3, 5},
            {2, 4}
        };
        
        // BFS
        Queue<String> q = new ArrayDeque();
        HashSet<String> visited = new HashSet();
        
        q.offer(start);
        visited.add(start);
        
        int step = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            // level-order traversal
            for (int i = 0; i < size; ++i) {
                String current = q.poll();
                // see if reaches the target
                if (current.equals(target)) {
                    return step;
                }
                // find the index of "0"
                int index = 0;
                for (; current.charAt(index) != '0'; ++index);
                // move '0' to diff directions to get next possible step
                for (int neighbor : neighbors[index]) {
                    String new_board = swap(current.toCharArray(), index, neighbor);
                    // avoid revisit
                    if (!visited.contains(new_board)) {
                        q.offer(new_board);
                        visited.add(new_board);
                    }
                }
            }
            // count level
            ++step;
        }
        // no solution
        return -1;
    }
    private String swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
        return new String(chars);
    }
}