package amazonreviewers.project.service.mapper;

import amazonreviewers.project.model.Comment;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataMapper {
    public Comment mapDataToModel(List<String> unParseData) {
        Comment comment = new Comment();
        comment.setId(unParseData.get(0));
        comment.setProductId(unParseData.get(1));
        comment.setUserId(unParseData.get(2));
        comment.setProfileName(unParseData.get(3));
        comment.setHelpfulnessNumerator(Long.parseLong(unParseData.get(4)));
        comment.setHelpfulnessDenominator(Long.parseLong(unParseData.get(5)));
        comment.setScore(Long.parseLong(unParseData.get(6)));
        comment.setTime(unParseData.get(7));
        comment.setSummary(unParseData.get(8));
        comment.setText(unParseData.get(9));
        return comment;
    }
}
