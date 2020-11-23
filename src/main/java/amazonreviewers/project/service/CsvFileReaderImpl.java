package amazonreviewers.project.service;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

public class CsvFileReaderImpl implements CsvFileReader {

    @Override
    public List<List<String>> readFile(String csvFilePath) {
        String[] line;
        List<List<String>> data = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(csvFilePath))) {
            while ((line = reader.readNext()) != null) {
                data.add(Arrays.asList(line));
            }
        } catch (CsvValidationException | IOException e) {
            throw new RuntimeException("Can't read the file.", e);
        }
        if (data.isEmpty()) {
            throw new NoSuchElementException("The file is empty.");
        }
        return data;
    }
}
