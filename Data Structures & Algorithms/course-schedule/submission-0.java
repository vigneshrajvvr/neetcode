class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        int[] indegree = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }

        for(int i = 0; i < prerequisites.length; i++) {
            adjList.get(prerequisites[i][0]).add(prerequisites[i][1]);
            indegree[prerequisites[i][1]]++;
        }

        for(int i = 0; i < indegree.length; i++) {
            if(indegree[i] == 0) {
                queue.add(i);
            }
        }

        if(queue.isEmpty()) {
            return false;
        }

        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int node = queue.remove();
                ArrayList<Integer> neighbours = adjList.get(node);

                for(int neighbour : neighbours) {
                    indegree[neighbour]--;
                    if(indegree[neighbour] == 0) {
                        queue.add(neighbour);
                    }
                }
            }
        }

        for(int i = 0; i < indegree.length; i++) {
            if(indegree[i] != 0) {
                return false;
            }
        }

        return true;
    }
}