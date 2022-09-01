class RandomizedSet {
    private ArrayList<Integer> nums;
    private HashMap<Integer, Integer> valToIndex;
    //
    private Random random;

    public RandomizedSet() {
        nums = new ArrayList<>();
        valToIndex = new HashMap<>();
        random = new Random();
    }
    
    public boolean insert(int val) {
        if (valToIndex.containsKey(val)) return false;
        nums.add(val);
        valToIndex.put(val, nums.size() - 1);
        return true;
    }
    
    public boolean remove(int val) {
        if (!valToIndex.containsKey(val)) return false;
       
        // get index of val
        int index = valToIndex.get(val);
        int last = nums.get(nums.size() - 1);
        // update the last num with index
        valToIndex.put(last, index);
        valToIndex.remove(val);
        // swap last with val
        nums.set(index, nums.set(nums.size() - 1, val));

        // remove last
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