class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] cheapestPrice = new int[n];
        Arrays.fill(cheapestPrice, Integer.MAX_VALUE);
        cheapestPrice[src] = 0;

        for(int i = 0; i < k + 1; i++) {
            int[] cheapestPriceCopy = Arrays.copyOf(cheapestPrice, n);
            for(int[] flight: flights) {
                if(cheapestPrice[flight[0]] == Integer.MAX_VALUE) {
                    continue;
                }

                cheapestPriceCopy[flight[1]] = Math.min(
                                                    cheapestPriceCopy[flight[1]],
                                                    cheapestPrice[flight[0]] + flight[2]
                                                );

            }

            cheapestPrice = Arrays.copyOf(cheapestPriceCopy, n);
        }

        return cheapestPrice[dst] == Integer.MAX_VALUE ? -1 : cheapestPrice[dst];
    }
}