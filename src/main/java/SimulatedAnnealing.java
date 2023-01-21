public class SimulatedAnnealing {

    private static final double ACCURACY = 0.9999;
    private static final int NUMBER_OF_ITERATIONS = 10000;

    public static double calculateBestRoute(Trip trip) {
        System.out.printf("--------- Start calculation of best route ---------%n%n");

        double bestDistance = trip.getDistance();
        System.out.printf("Initial distance of trip: %.2f%n", bestDistance);
        trip.getTrip().forEach(value -> System.out.print(value.toString()));

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
//            if (i % 100 == 0) {
//                System.out.println("Iteration #" + i);
//            }
        }
        System.out.printf("%nBest distance is %.2f with the following route:%n", bestDistance);
        trip.getTrip().forEach(value -> System.out.print(value.toString()));
        System.out.printf("%n--------- Calculation finished ---------%n%n");
        return bestDistance;

    }
}
