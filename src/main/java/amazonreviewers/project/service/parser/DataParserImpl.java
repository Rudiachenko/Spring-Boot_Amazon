package amazonreviewers.project.service.parser;

import amazonreviewers.project.exceptions.NoHeaderException;
import amazonreviewers.project.model.CommentDto;
import amazonreviewers.project.service.mapper.CommentDtoMapper;
import amazonreviewers.project.service.reader.CsvFileReaderImpl;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class DataParserImpl implements DataParser<CommentDto> {
    private static final String HEADER = "Id,ProductId,UserId,ProfileName,"
            + "HelpfulnessNumerator,HelpfulnessDenominator,Score,Time,Summary,Text";
    private static final Integer HEADER_ID = 0;
    private final CsvFileReaderImpl csvFileReader;
    private final CommentDtoMapper commentDtoMapper;

    public DataParserImpl(CsvFileReaderImpl csvFileReader, CommentDtoMapper commentDtoMapper) {
        this.csvFileReader = csvFileReader;
        this.commentDtoMapper = commentDtoMapper;
    }

    public List<CommentDto> parseData(String path) {
        List<List<String>> comments = csvFileReader.readFile(path);
        List<CommentDto> listWithCommentsModel = new ArrayList<>();
        String header = String.join(",", comments.get(HEADER_ID));
        if (!header.equals(HEADER)) {
            throw new NoHeaderException("File without header.");
        }
        for (int i = 1, commentsSize = comments.size(); i < commentsSize; i++) {
            List<String> columnList = comments.get(i);
            CommentDto commentDto = commentDtoMapper.mapDataToModel(columnList);
            listWithCommentsModel.add(commentDto);
        }
        return listWithCommentsModel;
    }
}
