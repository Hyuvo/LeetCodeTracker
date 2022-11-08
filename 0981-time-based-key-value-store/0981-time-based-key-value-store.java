class TimeMap {
    private HashMap<String, ArrayList<Pair<Integer, String>>> keyTimeMap;
    public TimeMap() {
        keyTimeMap = new HashMap();
    }
    // All the timestamps timestamp of set are strictly increasing.
    public void set(String key, String value, int timestamp) {
        if (!keyTimeMap.containsKey(key)) {
            keyTimeMap.put(key, new ArrayList<Pair<Integer, String>>());
        }
        keyTimeMap.get(key).add(new Pair(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if (!keyTimeMap.containsKey(key)) return "";
        // if timestamp is smaller than the min timestamp stored
        if (keyTimeMap.get(key).get(0).getKey() > timestamp) return "";
        
        // binary search right bound
        int left = 0, right = keyTimeMap.get(key).size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (keyTimeMap.get(key).get(mid).getKey() <= timestamp) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (right == -1) return "";
        return keyTimeMap.get(key).get(right).getValue();
    }
}

// class TimeMap {
//     private HashMap<String, TreeMap<Integer, String>> keyTimeMap;
//     public TimeMap() {
//         // treemap store timestamp ascendingly
//         keyTimeMap = new HashMap<String, TreeMap<Integer, String>>();
//     }
    
//     public void set(String key, String value, int timestamp) {
//         if (!keyTimeMap.containsKey(key)) {
//             keyTimeMap.put(key, new TreeMap<Integer, String>());
//         }
//         keyTimeMap.get(key).put(timestamp, value);
//     }
    
//     public String get(String key, int timestamp) {
//         if (!keyTimeMap.containsKey(key)) return "";
//         Integer floorKey = keyTimeMap.get(key).floorKey(timestamp);
        
//         return floorKey == null ? "" : keyTimeMap.get(key).get(floorKey);
//     }
// }

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */