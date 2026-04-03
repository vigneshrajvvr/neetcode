class Twitter {
    private int timestamp;
    private Map<Integer, Set<Integer>> followers;
    private Map<Integer, List<Tweet>> tweetsPosted;
    private PriorityQueue<Tweet> newsFeed;

    public Twitter() {
        followers = new HashMap<>();
        tweetsPosted = new HashMap();
        newsFeed = new PriorityQueue<>((a, b) -> {
            return a.timestamp - b.timestamp;
        });
    }
    
    public void postTweet(int userId, int tweetId) {
        if(!tweetsPosted.containsKey(userId)) {
            tweetsPosted.put(userId, new ArrayList<>());
        }
        
        tweetsPosted.get(userId).add(new Tweet(tweetId, timestamp));
        timestamp++;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> latestNewsFeed = new ArrayList<>();

        Set<Integer> followersList = new HashSet<>();
        if(followers.containsKey(userId)) {
            followersList.addAll(followers.get(userId));
        }
        followersList.add(userId);

        for(Integer follower : followersList) {
            if(tweetsPosted.containsKey(follower)) {
                for(Tweet currentTweet : tweetsPosted.get(follower)) {
                    newsFeed.add(currentTweet);
                    if(newsFeed.size() > 10) {
                        newsFeed.remove();
                    }
                }
            }
        }        

        while(!newsFeed.isEmpty()) {
            latestNewsFeed.add(0, newsFeed.remove().tweetId);
        }


        return latestNewsFeed;
    }
    
    public void follow(int followerId, int followeeId) {
        if(!followers.containsKey(followerId)) {
            followers.put(followerId, new HashSet<>());
        }
        followers.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followers.containsKey(followerId) && followers.get(followerId).contains(followeeId)) {
            followers.get(followerId).remove(followeeId);
        }
    }
}

class Tweet {
    int tweetId;
    int timestamp;

    public Tweet(int tweetId, int timestamp) {
        this.tweetId = tweetId;
        this.timestamp = timestamp;
    }
}

// Tweets
// 1 -> (5, 0)
// 2 -> (6, 1)

// Follow
// 1 -> 2

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */

 // userId -> List<tweeId, timestamp>
 // userId -> Set<userId>
 // Retreive the followers list and the current user as well
 // Iterate through the user list, get the list the posts for each user -> store in the minheap with the timestamp
