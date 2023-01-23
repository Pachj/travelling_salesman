import model.City;

import java.io.IOException;
import java.util.ArrayList;
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
        List<Trip> bestSolutions = SimulatedAnnealing.calculateBestRoute(trip);

        // Write output into file
        FileWriter.writeFile("bestSolutions.txt", bestSolutions);
    }

}
