package amazonreviewers.project.amazonreviewers.project.service.parser;

import amazonreviewers.project.model.Comment;
import java.util.List;

public interface DataParser {
    List<Comment> parseData(String path);
}
