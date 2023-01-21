package model;

import static java.lang.Double.parseDouble;

public class City {
    private double x;
    private double y;
    private String name;

    public City(double x, double y, String name) {
        this.x = x;
        this.y = y;
        this.name = name;
    }

    public int getX() {
        return (int) x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
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
        return "City{" +
                "x=" + x +
                ", y=" + y +
                ", name='" + name + '\'' +
                '}';
    }
}
