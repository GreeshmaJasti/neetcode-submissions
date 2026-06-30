class TimeMap {
    
    private Map<String, List<Pair<Integer, String>>> store;
    public TimeMap() {
        store = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!store.containsKey(key)){
            List<Pair<Integer, String>> al = new ArrayList<>();
            al.add(new Pair<>(timestamp, value));
            store.put(key, al);
        }
        else{
            List<Pair<Integer, String>> temp = store.get(key);
            temp.add(new Pair<>(timestamp, value));
            store.put(key, temp);
        }
    }
    
    public String get(String key, int timestamp) {
        String res="";
        if(!store.containsKey(key)){
            return "";
        }else{
            List<Pair<Integer, String>> al = store.get(key);
            int len = al.size();
            int low = 0, high = len-1;
            while(low <= high){
                int mid = low + (high-low)/2;
                if(al.get(mid).getKey() == timestamp)
                    return al.get(mid).getValue();
                else if(al.get(mid).getKey() < timestamp){
                    res = al.get(mid).getValue();
                    low = mid+1;
                }
                else
                    high = mid-1;
            }
        }
        return res;
    }
}
