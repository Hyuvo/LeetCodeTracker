class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        UnionFind uf = new UnionFind(n);
        // account id from 0 to n - 1
        HashMap<String, Integer> emailToId = new HashMap();
        
        // build union find and merge accounts per email
        for (int i = 0; i < n; ++i) {
            int size = accounts.get(i).size();
            for (int j = 1; j < size; ++j) {
                String mail = accounts.get(i).get(j);
                if (!emailToId.containsKey(mail)) {
                    // map a mail to its original account
                    emailToId.put(mail, i);
                } else {
                    // if seen the email before, merge 2 accounts
                    uf.union(i, emailToId.get(mail));
                }
            }
        }
        HashMap<Integer, List<String>> idToEmails = new HashMap();
        // map emails within the same union to the same account
        for (Map.Entry<String, Integer> entry : emailToId.entrySet()) {
            // find root account id
            int id = uf.find(entry.getValue());
            // merge emails with the same id
            List<String> emails = idToEmails.getOrDefault(id, new ArrayList<String>());
            emails.add(entry.getKey());
            idToEmails.put(id, emails);
        }
        // map username to email
        List<List<String>> result = new ArrayList();
        for (Map.Entry<Integer, List<String>> entry : idToEmails.entrySet()) {
            List<String> emails = entry.getValue();
            Collections.sort(emails);
            // add username (get from account id)
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(entry.getKey()).get(0));
            temp.addAll(emails);
            result.add(temp);
        }
        return result;
    }
}

class UnionFind {
    private int[] parent;
    
    public UnionFind(int n) {
        parent = new int[n];
        for (int i = 0; i < n; ++i) {
            parent[i] = i;
        }
    }
    
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        
        if (rootP == rootQ)
            return;
        parent[rootQ] = rootP;
        
    }
    // public boolean isConnected(int p, int q) {
    //     int rootP = find(p);
    //     int rootQ = find(q);
    //     return rootP == rootQ;
    // }
    // find root
    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
}