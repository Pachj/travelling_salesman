import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class SimulatedAnnealing {

    private static final double ACCURACY = 0.9999;
    private static final int NUMBER_OF_ITERATIONS = 10000;

    private static Set<Trip> solutions = new HashSet<>();

    public static List<Trip> calculateBestRoute(Trip trip) {
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

                solutions.add(currentSolution.clone());
                if (currentDistance < bestDistance) {
                    bestDistance = currentDistance;
                } else if (Math.exp((bestDistance - currentDistance) / t) < Math.random()) {
                    currentSolution.revertSwap();
                }
                t *= ACCURACY;
            }
        }
        List<Trip> threeBestSolutions = solutions.stream()
                .sorted(Comparator.comparing(Trip::getDistance))
                .limit(3)
                .collect(Collectors.toList());

        System.out.printf("%nThese are the best three routes%n");
        for (int i = 0; i < 3; i++) {
            System.out.printf("%nSolution %d%n%nDistance -> %.2f%n", i + 1, threeBestSolutions.get(i).getDistance());
            threeBestSolutions.get(i).getTrip().forEach(city -> System.out.print(city.toString()));
        }
        System.out.printf("%n--------- Calculation finished ---------%n%n");
        return threeBestSolutions;

    }

}
