package amazonreviewers.project.service.mapper;

import amazonreviewers.project.model.CommentDto;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class CommentDtoMapper {
    private static final Integer ID = 0;
    private static final Integer PRODUCT_ID = 1;
    private static final Integer USER_ID = 2;
    private static final Integer PROFILE_NAME = 3;
    private static final Integer HELPFULNESS_NUMERATOR = 4;
    private static final Integer HELPFULNESS_DENOMINATOR = 5;
    private static final Integer SCORE = 6;
    private static final Integer TIME = 7;
    private static final Integer SUMMARY = 8;
    private static final Integer TEXT = 9;

    public CommentDto mapDataToModel(List<String> unParseData) {
        CommentDto commentDto = new CommentDto();
        commentDto.setId(unParseData.get(ID));
        commentDto.setProductId(unParseData.get(PRODUCT_ID));
        commentDto.setUserId(unParseData.get(USER_ID));
        commentDto.setProfileName(unParseData.get(PROFILE_NAME));
        commentDto.setHelpfulnessNumerator(Long.parseLong(unParseData.get(HELPFULNESS_NUMERATOR)));
        commentDto.setHelpfulnessDenominator(Long.parseLong(unParseData
                .get(HELPFULNESS_DENOMINATOR)));
        commentDto.setScore(Long.parseLong(unParseData.get(SCORE)));
        commentDto.setTime(unParseData.get(TIME));
        commentDto.setSummary(unParseData.get(SUMMARY));
        commentDto.setText(unParseData.get(TEXT));
        return commentDto;
    }
}
