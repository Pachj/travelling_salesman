import model.City;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainApp {

    public static void main(String[] args) throws IOException {

        // Read File
        List<String[]> lines = FileReader.readFile("koordinatenliste.txt", ",");

        // Map to objects
        ArrayList<City> cities = new ArrayList<>();
        lines.forEach(values -> cities.add(City.mapToCity(values)));
        Trip trip = new Trip(cities);

        // Start calculation
        double bestRoute = SimulatedAnnealing.calculateBestRoute(trip);
        FileWriter.writeFile("bestSolution.txt", trip.getTrip().stream().toList() );
    }

}
