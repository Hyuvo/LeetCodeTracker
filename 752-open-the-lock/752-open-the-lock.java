class Solution {
    public int openLock(String[] deadends, String target) {
        // Use a set to store dead ends
        HashSet<String> deads = new HashSet<>();
        // use visited to track visited combinations
        HashSet<String> visited = new HashSet<>();
        
        for (String deadend : deadends) {
            deads.add(deadend);
        }
        
        Queue<String> q = new LinkedList<String>();
        q.offer("0000");
        visited.add("0000");
        
        int attempt = 0;
        
        while (!q.isEmpty()) {
            int size = q.size();
            // expand current queue
            for (int i = 0; i < size; ++i) {
                String current = q.poll();
                
                // skip the deadends
                if (deads.contains(current)) {
                    continue;
                }
                // see if it's the target
                if (current.equals(target)) {
                    return attempt;
                }
                
                // add its neighbors to the queue
                for (int j = 0; j < 4; ++j) {
                    String plus = plusOne(current, j);
                    if (!visited.contains(plus)) {
                        q.add(plus);
                        visited.add(plus);
                    }
                    
                    String minus = minusOne(current, j);
                    if (!visited.contains(minus)) {
                        q.add(minus);
                        visited.add(minus);
                    }
                }
                
            }
             attempt++;        
        }
        
        // if target is not reached
        return -1;
    }
    
    public String plusOne(String current, int i) {
        char[] code = current.toCharArray();
        if (code[i] == '9') {
            code[i] = '0';
        } else {
            code[i] += 1;
        }
        
        return new String(code);
    }
    
    public String minusOne(String current, int i) {
        char[] code = current.toCharArray();
        if (code[i] == '0') {
            code[i] = '9';
        } else {
            code[i] -= 1;
        }
        
        return new String(code);
    }
}