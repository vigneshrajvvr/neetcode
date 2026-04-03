class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        ArrayList<int[]> carFleetsDetails = new ArrayList<>();
        Stack<int[]> numberOfFleets = new Stack<>();

        for(int i = 0; i < position.length; i++) {
            carFleetsDetails.add(new int[]{position[i], speed[i]});
        }

        Collections.sort(carFleetsDetails, (a, b) -> {
            return b[0] - a[0];
        });

        for(int[] currentCar : carFleetsDetails) {
            if(numberOfFleets.isEmpty()) {
                numberOfFleets.add(currentCar);
            } else {
                int[] peekCar = numberOfFleets.peek();
                double distance1 = (target - peekCar[0]) / (1.0 * peekCar[1]);
                double distance2 = (target - currentCar[0]) / (1.0 * currentCar[1]);

                if(distance2 > distance1) {
                    numberOfFleets.add(currentCar);
                }
            }
        }

        return numberOfFleets.size();
    }
}