class RandomizedSet {
    // in order to get random num with equal probability,
    // the set has to be implemented by an array underneath
    private ArrayList<Integer> nums;
    // to track the index of each num in the arrray
    private HashMap<Integer, Integer> valueToIndex;
    private Random random;
    
    public RandomizedSet() {
        this.nums = new ArrayList<>();
        this.valueToIndex = new HashMap<>();
        this.random = new Random();
    }
    
    public boolean insert(int val) {
        if (valueToIndex.containsKey(val)) return false;
        
        nums.add(val);
        valueToIndex.put(val, nums.size() - 1);
        return true;
    }
    
    public boolean remove(int val) {
        if (!valueToIndex.containsKey(val)) return false;
        
        int index = valueToIndex.get(val);
        valueToIndex.put(nums.get(nums.size() - 1), index);     
        valueToIndex.remove(val);
        nums.set(index, nums.get(nums.size() - 1));
        nums.remove(nums.size() - 1);

        return true;
        
    }
    
    public int getRandom() {
        return nums.get(random.nextInt(nums.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */