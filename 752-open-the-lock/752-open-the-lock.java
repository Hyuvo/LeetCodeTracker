class Solution {
    // return the minimum total number of turns required to open the lock, or -1 if it is impossible.
    // BFS
    public int openLock(String[] deadends, String target) {
        // use set to track deadends and visited combination
        Set<String> deads = new HashSet();
        for (String dead : deadends) {
            deads.add(dead);
        }
        Set<String> visited = new HashSet();
        
        // start from '0000'
        Queue<String> q = new LinkedList();
        q.offer("0000");
        visited.add("0000");
        // track the # of turns
        int num = 0;
        
        while(!q.isEmpty()) {
            int size = q.size();
            // traverse current level
            for (int i = 0; i < size; ++i) {
                String current = q.poll();
                // skil deadends
                if (deads.contains(current)) continue;
                
                if (current.equals(target)) {
                    return num;
                }
                // add current node's children to the q
                // each wheel can be turn up and down
                // for each wheel
                for(int j = 0; j < 4; ++j) {
                    String up = plusOne(current, j);
                    if (!visited.contains(up)) {
                        q.offer(up);
                        visited.add(up);
                    }
                    String down = minusOne(current, j);
                    if (!visited.contains(down)) {
                        q.offer(down);
                        visited.add(down);
                    }                    
                }
            }
            num++;
        }
        // if tried every combination, but still not reach target
        return -1;
    }
    
    public String plusOne(String s, int i) {
        char[] code = s.toCharArray();
        if (code[i] == '9') {
            code[i] = '0';           
        } else {
            code[i] += 1;
            // code[i]++ works?
        }
        return new String(code);
    }
    
    public String minusOne(String s, int i) {
        char[] code = s.toCharArray();
        if (code[i] == '0') {
            code[i] = '9';
        } else {
            code[i] -= 1;
        }
        return new String(code);
    }
}