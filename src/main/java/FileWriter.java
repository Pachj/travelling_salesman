import model.City;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class FileWriter {

    public static void writeFile(String path, List<City> values) throws IOException {
        java.io.FileWriter writer = new java.io.FileWriter(path);
        List<String> valuesAsString = values.stream().map(City::toString).collect(Collectors.toList());
        writer.write(String.join("", valuesAsString));
        writer.close();
    }

}
