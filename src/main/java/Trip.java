import model.City;

import java.util.ArrayList;
import java.util.Random;

public class Trip {

    private final Random random = new Random();
    private ArrayList<City> trip;
    private ArrayList<City> previousTrip;

    Trip(ArrayList<City> cities) {
        trip = cities;
        previousTrip = new ArrayList<>();
    }

    public ArrayList<City> getTrip() {
        return trip;
    }

    public double calculateDistance() {
        double distance = 0.0;
        for (int i = 0; i < trip.size(); i++) {
            City startDestination = trip.get(i);
            City nextDestination;
            if (i + 1 < trip.size()) {
                nextDestination = trip.get(i + 1);
            } else {
                nextDestination = trip.get(0);
            }
            distance += calculateDistanceBetweenDestination(startDestination, nextDestination);
        }
        return distance;
    }

    public void swapCities() {
        int firstRandomIndex = generateRandomIndex();
        int secondRandomIndex = generateRandomIndex();
        previousTrip = new ArrayList<>(trip);
        City x = trip.get(firstRandomIndex);
        City y = trip.get(secondRandomIndex);
        trip.set(firstRandomIndex, y);
        trip.set(secondRandomIndex, x);
    }

    public void revertSwap() {
        trip = previousTrip;
    }

    @Override
    public String toString() {
        String tripAsString = "";
        for (int i = 0; i < trip.size(); i++) {
            if (i == trip.size() - 1) {
                tripAsString = String.format("%s%s%n%n", tripAsString, trip.get(i).getName());
            } else {
                tripAsString = String.format("%s%s -> ", tripAsString, trip.get(i).getName());
            }
        }
        return tripAsString;
    }

    @Override
    public Trip clone() {
        return new Trip(new ArrayList<>(this.trip));
    }

    private double calculateDistanceBetweenDestination(City startDestination, City targetDestination) {
        double xCoordinate = Math.abs(startDestination.getXCoordinate() - targetDestination.getXCoordinate());
        double yCoordinate = Math.abs(startDestination.getYCoordinate() - targetDestination.getYCoordinate());
        return Math.sqrt(Math.pow(xCoordinate, 2) + Math.pow(yCoordinate, 2));
    }

    private int generateRandomIndex() {
        return random.nextInt(1, trip.size());
    }
}
