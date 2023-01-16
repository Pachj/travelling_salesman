import java.io.IOException;
import java.util.List;

public class FileWriter {

    public void writeFile(String path, List<String> values, String header) throws IOException {
        values.add(0, header);
        java.io.FileWriter writer = new java.io.FileWriter(path);
        writer.write(String.join("", values));
        writer.close();
    }

}
