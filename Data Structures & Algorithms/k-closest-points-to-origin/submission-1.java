class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> kClosestPoints = new PriorityQueue<>((a, b) -> {
            double distance1 = Math.abs(Math.sqrt(a[0] * a[0] + a[1] * a[1]));
            double distance2 = Math.abs(Math.sqrt(b[0] * b[0] + b[1] * b[1]));
            if(distance1 < distance2) {
                return 1;
            } else if(distance1 > distance2) {
                return -1;
            }

            return 0;
        });

        for(int i = 0; i < points.length; i++) {
            kClosestPoints.add(points[i]);
            if(kClosestPoints.size() > k) {
                kClosestPoints.poll();
            }
        }

        int[][] result = new int[kClosestPoints.size()][2];
        for(int i = 0; i < result.length; i++) {
            result[i] = kClosestPoints.poll();
        }

        return result;
    }
}
