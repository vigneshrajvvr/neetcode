class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        ArrayList<int[]> carFleetsDetails = new ArrayList<>();
        int numberOfFleets = 0;
        int[] topFleet = new int[2];

        for(int i = 0; i < position.length; i++) {
            carFleetsDetails.add(new int[]{position[i], speed[i]});
        }

        Collections.sort(carFleetsDetails, (a, b) -> {
            return b[0] - a[0];
        });

        topFleet = carFleetsDetails.get(0);
        for(int i = 1; i < carFleetsDetails.size(); i++) {
            double distance1 = (target - topFleet[0]) / (1.0 * topFleet[1]);
            double distance2 = (target - carFleetsDetails.get(i)[0]) / (1.0 * carFleetsDetails.get(i)[1]);

            if(distance2 > distance1) {
                topFleet = carFleetsDetails.get(i);
                numberOfFleets++;
            }
        }

        return numberOfFleets + 1;
    }
}