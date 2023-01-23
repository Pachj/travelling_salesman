import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FileReader {

    public static List<String[]> readFile(String path, String separator) throws IOException {
        List<String[]> fileAsList = new ArrayList<>();
        String fileAsString = new Scanner(new File(path)).useDelimiter("\\Z").next();

        Arrays.stream(fileAsString.split("\n")).forEach(line -> {
            String[] values = line.trim().split(separator);
            fileAsList.add(values);
        });

        return fileAsList;
    }
}
