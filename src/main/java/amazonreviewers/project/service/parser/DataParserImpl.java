package amazonreviewers.project.service.parser;

import amazonreviewers.project.model.Comment;
import amazonreviewers.project.service.mapper.DataMapper;
import amazonreviewers.project.service.reader.CsvFileReaderImpl;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataParserImpl implements DataParser {
    private final static String PATH = "src/main/resources/reviews.csv";
    private final CsvFileReaderImpl csvFileReader;
    private final DataMapper dataMapper;

    public DataParserImpl(CsvFileReaderImpl csvFileReader, DataMapper dataMapper) {
        this.csvFileReader = csvFileReader;
        this.dataMapper = dataMapper;
    }

    public List<Comment> parseData() {
        List<List<String>> comments = csvFileReader.readFile(PATH);
        List<Comment> listWithCommentsModel = new ArrayList<>();
        for (int i = 1, commentsSize = comments.size(); i < commentsSize; i++) {
            List<String> columnList = comments.get(i);
            Comment comment = dataMapper.mapDataToModel(columnList);
            listWithCommentsModel.add(comment);
        }
        return listWithCommentsModel;
    }
}