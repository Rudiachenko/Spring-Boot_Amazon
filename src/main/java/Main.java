import amazonreviewers.project.model.Comment;
import amazonreviewers.project.service.mapper.DataMapper;
import amazonreviewers.project.service.parser.DataParserImpl;
import amazonreviewers.project.service.reader.CsvFileReaderImpl;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        String pathToCsv = "src/main/resources/reviews.csv";
        CsvFileReaderImpl csvFileReader = new CsvFileReaderImpl();
        DataMapper dataMapper = new DataMapper();
        DataParserImpl dataParser = new DataParserImpl(csvFileReader, dataMapper);
        List<Comment> comments = dataParser.parseData();
        for (Comment comment : comments) {
            System.out.println(comment);
            System.out.println();
        }
    }
}
