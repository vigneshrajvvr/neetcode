class TimeMap {
    HashMap<String, ArrayList<Pair>> lookup;

    public TimeMap() {
        lookup = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!lookup.containsKey(key)) {
            lookup.put(key, new ArrayList<>());
        }
        lookup.get(key).add(new Pair(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if(!lookup.containsKey(key)) {
            return "";
        }
        String result = "";
        ArrayList<Pair> possibleList = lookup.get(key);
        int start = 0;
        int end = possibleList.size() - 1;

        while(start <= end) {
            int mid = (start + end) / 2;
            if(possibleList.get(mid).timestamp == timestamp) {
                result = possibleList.get(mid).value;
                break;
            } else if(possibleList.get(mid).timestamp < timestamp) {
                result = possibleList.get(mid).value;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return result;
    }
}

class Pair {
    int timestamp;
    String value;

    public Pair(int timestamp, String value) {
        this.timestamp = timestamp;
        this.value = value;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */

 // ["TimeMap","set","set","get","get","get","get","get"]
 // [[],["love","high",10],["love","low",20],["love",5],["love",10],["love",15],["love",20],["love",25]]

 // love -> 10, high - 20, low