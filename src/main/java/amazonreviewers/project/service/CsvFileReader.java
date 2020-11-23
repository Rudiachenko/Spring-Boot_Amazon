package amazonreviewers.project.service;

import java.util.List;

public interface CsvFileReader {
    List<List<String>> readFile(String path);
}
