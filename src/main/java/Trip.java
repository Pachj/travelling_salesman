import model.City;

import java.util.ArrayList;

public class Trip {

    private ArrayList<City> destinations;

    Trip(ArrayList<City> cities) {
        destinations = cities;
    }

    public ArrayList<City> getDestinations() {
        return destinations;
    }

    public void addDestinationToList(City additionalCity) {
        this.destinations.add(additionalCity);
    }

    public int getDistance() {
        int distance = 0;
        for (int i = 0; i < destinations.size(); i++) {
            City startDestination = destinations.get(i);
            City nextDestination;
            if (i + 1 < destinations.size()) {
                nextDestination = destinations.get(i + 1);
            } else {
                nextDestination = destinations.get(0);
            }
            distance += calculateDistanceBetweenDestination(startDestination, nextDestination);
        }
        return distance;
    }

    public void swapCities() {
        int a = generateRandomIndex();
        int b = generateRandomIndex();
        previousTravel = new ArrayList<>(travel);
        City x = travel.get(a);
        City y = travel.get(b);
        travel.set(a, y);
        travel.set(b, x);
    }

    private double calculateDistanceBetweenDestination(City startDestination, City targetDestination) {
        int xCoordinate = Math.abs(startDestination.getX() - targetDestination.getX());
        int yCoordinate = Math.abs(startDestination.getY() - targetDestination.getY());
        return Math.sqrt(Math.pow(xCoordinate, 2) + Math.pow(yCoordinate, 2));
    }

}
