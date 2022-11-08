class TimeMap {
    private HashMap<String, TreeMap<Integer, String>> keyTimeMap;
    public TimeMap() {
        // treemap store timestamp ascendingly
        keyTimeMap = new HashMap<String, TreeMap<Integer, String>>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!keyTimeMap.containsKey(key)) {
            keyTimeMap.put(key, new TreeMap<Integer, String>());
        }
        keyTimeMap.get(key).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        if (!keyTimeMap.containsKey(key)) return "";
        Integer floorKey = keyTimeMap.get(key).floorKey(timestamp);
        
        return floorKey == null ? "" : keyTimeMap.get(key).get(floorKey);
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */