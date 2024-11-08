class LRUCache {
    int c;
    HashMap<Integer, Integer> cache;
    HashMap<Integer, Integer> usageOrder;
    int OrderCounter;

    public LRUCache(int capacity) {
        this.c = capacity;
        this.cache = new HashMap<>();
        this.usageOrder = new HashMap<>();
        this.OrderCounter = 0;
    }
    
    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        this.usageOrder.put(key, OrderCounter++);
        return cache.get(key);
    }
    
    public void put(int key, int value) {
        if (cache.size() >= c && !cache.containsKey(key)) {
            int lruKey = getLeastRecentlyUsedKey();
            cache.remove(lruKey);
            usageOrder.remove(lruKey);
        }
        cache.put(key, value);
        usageOrder.put(key, OrderCounter++);
    }
    public int getLeastRecentlyUsedKey() {
        int minOrder = Integer.MAX_VALUE;
        int lruKey = -1;
        for (HashMap.Entry<Integer, Integer> entry : usageOrder.entrySet()) {
            if (entry.getValue() < minOrder) {
                minOrder = entry.getValue();
                lruKey = entry.getKey();
            }
        }
        return lruKey;
    }
}