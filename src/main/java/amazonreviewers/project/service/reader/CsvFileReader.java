package amazonreviewers.project.service.reader;

import java.util.List;

public interface CsvFileReader {
    List<List<String>> readFile(String path);
}
