class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, List<String>> adjList = new HashMap<>();
        List<String> validItinerary = new ArrayList<>();

        // Sorting the tickets in lexographical order
        Collections.sort(tickets, (a, b) -> {
            if(a.get(0).equals(b.get(0))) {
                return a.get(1).compareTo(b.get(1));
            }

            return a.get(0).compareTo(b.get(0));
        });        

        // creating adjaceny list
        for(List<String> ticket : tickets) {
            if(!adjList.containsKey(ticket.get(0))) {
                adjList.put(ticket.get(0), new ArrayList<>());
            }

            adjList.get(ticket.get(0)).add(ticket.get(1));
        }

        dfs(adjList, validItinerary, "JFK");

        Collections.reverse(validItinerary);

        return validItinerary;
    }

    private void dfs(Map<String, List<String>> adjList, List<String> validItinerary, String node) {
        List<String> routes = adjList.get(node);

        while(routes != null && !routes.isEmpty()) {
            String currentRoute = routes.remove(0);

            dfs(adjList, validItinerary, currentRoute);
        }

        validItinerary.add(node);
    }
}

// MUC -> LHR
// JKF -> MUC
// SFO -> SJC
// LHR -> SFO

// JFK -> ATL, SFO
// SFO -> ATL
// ATL -> JFK, SFO