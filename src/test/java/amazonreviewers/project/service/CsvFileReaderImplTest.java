package amazonreviewers.project.service;

import amazonreviewers.project.exceptions.NoHeaderException;
import amazonreviewers.project.service.mapper.DataMapper;
import amazonreviewers.project.service.parser.DataParser;
import amazonreviewers.project.service.parser.DataParserImpl;
import amazonreviewers.project.service.reader.CsvFileReader;
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
    private static final String PATH_EMPTY_LIST = "src/test/java/resources/emptyList.csv";
    private static final String LIST_WITHOUT_HEADER = "src/test/java/resources/listWithoutHeader.csv";
    private static final String NOT_EMPTY_LIST = "src/test/java/resources/notEmptyList.csv";
    List<String> firstList;
    List<String> secondList;
    List<String> thirdList;
    List<List<String>> listForList;

    public CsvFileReaderImpl createReader() {
        return new CsvFileReaderImpl();
   }

    public DataMapper createDataMapper() {
        return new DataMapper();
    }

    public DataParser createDataParser() {
        return new DataParserImpl(createReader(), createDataMapper());
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

    @Test(expected = NoHeaderException.class)
    public void fileWithoutHeader() {
        createDataParser().parseData(LIST_WITHOUT_HEADER);
    }

    @Test
    public void isNotEmptyFileTest() {
        Assert.assertEquals(listForList,
                createReader()
                        .readFile(NOT_EMPTY_LIST));
    }
}
