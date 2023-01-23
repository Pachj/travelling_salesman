import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileWriter {

    public static void writeFile(String path, List<Trip> trips) throws IOException {
        java.io.FileWriter writer = new java.io.FileWriter(path);
        List<String> tripAsString = new ArrayList<>();
        for (int i = 0; i < trips.size(); i++) {
            tripAsString.add(String.format("%nSolution %d%n%nDistance -> %.2f%n", i + 1, trips.get(i).calculateDistance()));
            tripAsString.add(trips.get(i).toString());
        }
        writer.write(String.join("", tripAsString));
        writer.close();
    }

}
