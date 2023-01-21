package model;

import static java.lang.Double.parseDouble;

public class City {
    private double xCoordinate;
    private double yCoordinate;
    private String name;

    public City(double xCoordinate, double yCoordinate, String name) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.name = name;
    }

    public int getXCoordinate() {
        return (int) xCoordinate;
    }

    public void setXCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public double getYCoordinate() {
        return yCoordinate;
    }

    public void setYCoordinate(int yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static City mapToCity(String[] values) {
        return new City(parseDouble(values[1]), parseDouble(values[2]), values[0]);
    }

    @Override
    public String toString() {
        return """
                City: %s, Coordinates: %f, %f
                """.formatted(name, xCoordinate, yCoordinate);
    }
}
