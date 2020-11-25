package amazonreviewers.project.service;

import amazonreviewers.project.exceptions.NoHeaderException;
import amazonreviewers.project.model.CommentDto;
import amazonreviewers.project.service.mapper.CommentDtoMapper;
import amazonreviewers.project.service.parser.DataParserImpl;
import amazonreviewers.project.service.reader.CsvFileReaderImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class CsvFileReaderImplTest {
    private static final Integer OBJECT = 0;
    private static final String ID = "1965";
    private static final String PRODUCT_ID = "B001FQ0UEE";
    private static final String USER_ID = "ABWUZU0SCL5PW";
    private static final String PROFILE_NAME = "Howard M.";
    private static final Long HELPFULNESS_NUMERATOR = 2L;
    private static final Long HELPFULNESS_DENOMINATOR = 2L;
    private static final Long SCORE = 5L;
    private static final String TIME = "1313539200";
    private static final String SUMMARY = "Absolutely wonderful";
    private static final String TEXT = "A family favorite.  These are really unique treats.  "
            + "The wonderful taste of flowers.  The violet and rose are great.  "
            + "Orange blossom wasn't to my liking.  The company that makes them "
            + "have been around for hundreds of years.  They are made in a small French "
            + "town that was featured in a movie called \"Chocolat.\"";
    private static final String PATH_EMPTY_LIST = "src/test/java/resources/emptyList.csv";
    private static final String LIST_WITHOUT_HEADER = "src/test/java/resources/listWithoutHeader.csv";
    private static final String NOT_EMPTY_LIST = "src/test/java/resources/notEmptyList.csv";
    private static final String TEST_PARSER = "src/test/java/resources/testParserFile.csv";
    List<String> firstList;
    List<String> secondList;
    List<String> thirdList;
    List<List<String>> listForList;

    public CsvFileReaderImpl createReader() {
        return new CsvFileReaderImpl();
    }

    public CommentDtoMapper createCommentDtoMapper() {
        return new CommentDtoMapper();
    }

    public DataParserImpl createDataParser() {
        return new DataParserImpl(createReader(), createCommentDtoMapper());
    }


    @Before
    public void before() {
        firstList = new ArrayList<>();
        secondList = new ArrayList<>();
        thirdList = new ArrayList<>();
        listForList = new ArrayList<>();

        List<String> firstList = Arrays.stream(("Id,ProductId,UserId,ProfileName,HelpfulnessNumerator," +
                "HelpfulnessDenominator,Score,Time,Summary,Text")
                .split(","))
                .collect(Collectors.toList());
        secondList.add("test");
        secondList.add("line1");
        thirdList.add("test");
        thirdList.add("line2");

        listForList.add(firstList);
        listForList.add(secondList);
        listForList.add(thirdList);
    }

    @Test(expected = NoSuchElementException.class)
    public void isEmptyFileTest() {
        createReader().readFile(PATH_EMPTY_LIST);
    }

    @Test
    public void isNotEmptyFileTest() {
        Assert.assertEquals(listForList,
                createReader()
                        .readFile(NOT_EMPTY_LIST));
    }

    @Test(expected = NoHeaderException.class)
    public void fileWithoutHeader() {
        createDataParser().parseData(LIST_WITHOUT_HEADER);
    }

    @Test
    public void parseIsOk() {
        CommentDto commentDto = new CommentDto();
        commentDto.setId(ID);
        commentDto.setProductId(PRODUCT_ID);
        commentDto.setUserId(USER_ID);
        commentDto.setProfileName(PROFILE_NAME);
        commentDto.setHelpfulnessNumerator(HELPFULNESS_NUMERATOR);
        commentDto.setHelpfulnessDenominator(HELPFULNESS_DENOMINATOR);
        commentDto.setScore(SCORE);
        commentDto.setTime(TIME);
        commentDto.setSummary(SUMMARY);
        commentDto.setText(TEXT);
        List<CommentDto> commentDtos = createDataParser().parseData(TEST_PARSER);
        Assert.assertEquals(commentDto, commentDtos.get(OBJECT));
    }
}
