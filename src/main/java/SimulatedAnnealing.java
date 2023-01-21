public class SimulatedAnnealing {

    private static final double ACCURACY = 0.9999;
    private static final int NUMBER_OF_ITERATIONS = 10000;

    public static double calculateBestRoute(Trip trip) {
        System.out.println("Start calculation of best route.");
        double bestDistance = trip.getDistance();
        System.out.println("Initial distance of travel: " + bestDistance);
        Trip bestSolution = trip;
        Trip currentSolution = bestSolution;

        double t = 10;
        for (int i = 0; i < NUMBER_OF_ITERATIONS; i++) {
            if (t > 0.1) {
                currentSolution.swapCities();
                double currentDistance = currentSolution.getDistance();
                if (currentDistance < bestDistance) {
                    bestDistance = currentDistance;
                } else if (Math.exp((bestDistance - currentDistance) / t) < Math.random()) {
                    currentSolution.revertSwap();
                }
                t *= ACCURACY;
            } else {
                continue;
            }
            if (i % 100 == 0) {
                System.out.println("Iteration #" + i);
            }
        }
        return bestDistance;

    }

//    private static Travel travel = new Travel(10);
//
//    // startingTemperature (10?)
//    // irgendeinen Wert (10000?)
//    // coolingRate --> accuracy --> wie genau, auf 0.999 setzen
//    public static double simulateAnnealing(int numberOfIterations, double accuracy) {
//        System.out.println("Starting SA with temperature: " + startingTemperature + ", # of iterations: " + numberOfIterations + " and colling rate: " + accuracy);
//        double t = 10;
//        travel.generateInitialTravel();
//        double bestDistance = travel.getDistance();
//        System.out.println("Initial distance of travel: " + bestDistance);
//        Travel bestSolution = travel;
//        Travel currentSolution = bestSolution;
//
//        for (int i = 0; i < numberOfIterations; i++) {
//            if (t > 0.1) {
//                currentSolution.swapCities();
//                double currentDistance = currentSolution.getDistance();
//                if (currentDistance < bestDistance) {
//                    bestDistance = currentDistance;
//                } else if (Math.exp((bestDistance - currentDistance) / t) < Math.random()) {
//                    currentSolution.revertSwap();
//                }
//                t *= accuracy;
//            } else {
//                continue;
//            }
//            if (i % 100 == 0) {
//                System.out.println("Iteration #" + i);
//            }
//        }
//        return bestDistance;
//    }
//
}
