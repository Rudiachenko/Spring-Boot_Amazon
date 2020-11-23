package amazonreviewers.project.service.parser;

import amazonreviewers.project.exceptions.NoHeaderException;
import amazonreviewers.project.model.Comment;
import amazonreviewers.project.service.mapper.DataMapper;
import amazonreviewers.project.service.reader.CsvFileReaderImpl;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class DataParserImpl implements DataParser {
    private static final String HEADER = "Id,ProductId,UserId,ProfileName,"
            + "HelpfulnessNumerator,HelpfulnessDenominator,Score,Time,Summary,Text";
    private final CsvFileReaderImpl csvFileReader;
    private final DataMapper dataMapper;

    public DataParserImpl(CsvFileReaderImpl csvFileReader, DataMapper dataMapper) {
        this.csvFileReader = csvFileReader;
        this.dataMapper = dataMapper;
    }

    public List<Comment> parseData(String path) {
        List<List<String>> comments = csvFileReader.readFile(path);
        List<Comment> listWithCommentsModel = new ArrayList<>();
        for (int i = 0, commentsSize = comments.size(); i < commentsSize; i++) {
            if (i == 0) {
                String header = String.join(",", comments.get(i));
                if (!header.equals(HEADER)) {
                    throw new NoHeaderException("File without header.");
                }
                continue;
            }
            List<String> columnList = comments.get(i);
            Comment comment = dataMapper.mapDataToModel(columnList);
            listWithCommentsModel.add(comment);
        }
        return listWithCommentsModel;
    }
}
