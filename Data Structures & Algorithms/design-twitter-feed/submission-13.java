class Twitter{
    Map<Integer, List<Pair<Integer, Integer>>> mp;
    Map<Integer, List<Integer>> followers;
    int time = 0;

    public Twitter() {
        mp = new HashMap<>();
        followers = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        time++;
        if(!mp.containsKey(userId)){
            List<Pair<Integer, Integer>> l = new ArrayList<>();
            l.add(new Pair<>(tweetId, time));
            mp.put(userId, l);
        }else{
            List<Pair<Integer, Integer>> l = mp.get(userId);
            l.add(new Pair<>(tweetId, time));
            mp.put(userId, l);
        }
    }
    
    public List<Integer> getNewsFeed(int userId) {
        Map<Integer, Integer> temp = new HashMap<>();
        List<Pair<Integer, Integer>> myTweets = mp.get(userId);

        if(myTweets != null)
            for(Pair<Integer, Integer> tweetPair: myTweets){
                temp.put(tweetPair.getValue(), tweetPair.getKey());
            }

        List<Integer> followees = followers.get(userId);
        if(followees != null)
            for(int followeeId: followees){
                List<Pair<Integer, Integer>> tweets = mp.get(followeeId);

                for(Pair<Integer, Integer> tweetPair: tweets){
                    temp.put(tweetPair.getValue(), tweetPair.getKey());
                }
            }

        List<Integer> result = temp.entrySet()
            .stream()
            .sorted(Map.Entry.<Integer, Integer>comparingByKey().reversed())
            .limit(10)
            .map(Map.Entry::getValue)
            .collect(Collectors.toList());
        return result;
    }
    
    public void follow(int followerId, int followeeId) {
        if(followers.containsKey(followerId)){
            List<Integer> l = followers.get(followerId);
            if(!l.contains(followeeId)){
                l.add(followeeId);
                followers.put(followerId, l);
            }
        }else{
            List<Integer> l = new ArrayList<>();
            l.add(followeeId);
            followers.put(followerId, l);
        }
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followers.containsKey(followerId)){
            List<Integer> l = followers.get(followerId);
            l.remove(Integer.valueOf(followeeId));
            followers.put(followerId, l);
        }
    }
}
