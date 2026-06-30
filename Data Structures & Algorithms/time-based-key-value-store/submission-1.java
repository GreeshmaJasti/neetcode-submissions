class TimeMap {

    // Approach - We are storing in a map, where key is string and value is a list of pairs with timestamp as key and string as its value.
    // set - check if we already have key, if exists add new one to the existing list of pairs, else create a new array list
    // get - check for the key in map, if not present return "", otherwise
    // Applying binary search and if exact timestamp match avaliable - return it.
    // Otherwise, In the less condition, we are storing result , as we need timestamp_prev <= timestamp
    // Finally return the value in res. 
    
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
