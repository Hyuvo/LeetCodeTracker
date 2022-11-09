class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        UnionFind uf = new UnionFind(n);
        HashMap<String, Integer> emailToId = new HashMap();
        // email => account id, merge accounts if have same email
        for (int i = 0; i < n; ++i) {
            int size = accounts.get(i).size();
            for (int j = 1; j < size; ++j) {
                String email = accounts.get(i).get(j);
                if (!emailToId.containsKey(email)) {
                    emailToId.put(email, i);
                } else {
                    uf.union(i, emailToId.get(email));
                }
            }
        }
        // account => id, merge if have same uf root
        HashMap<Integer, List<String>> idToEmails = new HashMap();
        for (Map.Entry<String, Integer> entry : emailToId.entrySet()) {
            // find root account id
            int id = uf.find(entry.getValue());
            // merge emails
            List<String> emails = idToEmails.getOrDefault(id, new ArrayList<String>());
            emails.add(entry.getKey());
            idToEmails.put(id, emails);
        }
        // combine username and sorted emails
        List<List<String>> result = new ArrayList();
        for (Map.Entry<Integer, List<String>> entry : idToEmails.entrySet()) {
            int id = entry.getKey();
            // get username per id from accounts
            String name = accounts.get(id).get(0);
            List<String> emails = entry.getValue();
            Collections.sort(emails);
            
            List<String> temp = new ArrayList<>();
            temp.add(name);
            temp.addAll(emails);
            result.add(temp);
        }
        return result;
    }
}

class UnionFind {
    int[] parent;
    
    public UnionFind(int n) {
        parent = new int[n];
        for (int i = 0; i < n; ++i) {
            parent[i] = i;
        }
    }
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) return;
        parent[rootQ] = rootP;
    }
    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
}