import model.City;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainApp {

    public static void main(String[] args) throws IOException {

        // Read File
        List<String[]> lines = FileReader.readFile("Koordinatenliste.txt", ",");

        ArrayList<City> cities = new ArrayList<>();
        lines.forEach(values -> cities.add(City.mapToCity(values)));

        Trip trip = new Trip(cities);

        trip.getTrip().forEach(value -> System.out.println(value.toString()));

        double bestRoute = SimulatedAnnealing.calculateBestRoute(trip);
        System.out.println("bestRoute = " + bestRoute);
        trip.getTrip().forEach(value -> System.out.println(value.toString()));
    }

}
