class Solution {
    private Map<Integer, List<Pair<Integer, Integer>>> adj = new HashMap<>();
    public int networkDelayTime(int[][] times, int n, int k) {
        // weight is non-negative, weighted directive graph => Dijkstra
        // return max{min{costs}}
        // first build adjacent list
        for (int[] time : times) {
            int source = time[0];
            int des = time[1];
            int cost = time[2];
            
            adj.putIfAbsent(source, new ArrayList<>());
            adj.get(source).add(new Pair(cost, des));
        }
        // init distance[] from source to all nodes, nodes label start from 1
        int[] distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        
        // apply dijsktra to update distance[];
        dijsktra(distance, k, n);
        
        // find the longest time within shortest time
        int result = Integer.MIN_VALUE;
        // for (int time: distance) {
        //     result = Math.max(result, time);
        //     // if there exists not reachable node
        //     if (time == Integer.MIN_VALUE) return -1;
        // }
        
        // start from 1
        for (int i = 1; i <= n; ++i) {
            result = Math.max(result, distance[i]);
            if (distance[i] == Integer.MAX_VALUE) return -1;
        }
        
        return result;
        
        
        
    }
    
    public void dijsktra(int[] distance, int source, int n) {
        // Pair(toNodeDistance, node)
        Queue<Pair<Integer, Integer>> pq = new PriorityQueue<>(Comparator.comparing(Pair::getKey)); // method reference
        
        pq.add(new Pair(0, source)); // d(source, source) = 0
        distance[source] = 0;
        
        while(!pq.isEmpty()) {
            Pair<Integer, Integer> pair = pq.remove();
            // current node
            int current = pair.getValue();
            // from source to current node
            int toCurrent = pair.getKey();
            
            // already have a shorter route to current node
            if (toCurrent > distance[current]) {
                continue;
            }
            // if the current node is not going to anywhere. out degree = 0
            if (!adj.containsKey(current)) {
                continue;
            }
            
            // broadcast to neighbors
            for (Pair<Integer, Integer> edge : adj.get(current)) {
                int cost = edge.getKey();
                int des = edge.getValue();
                
                if (distance[des] > toCurrent + cost) {
                    distance[des] = toCurrent + cost;
                    pq.add(new Pair(distance[des], des));
                    
                }
            }
            
        }
        
    }
}