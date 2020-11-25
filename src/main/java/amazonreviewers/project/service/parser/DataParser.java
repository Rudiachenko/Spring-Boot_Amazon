package amazonreviewers.project.service.parser;

import java.util.List;

public interface DataParser<T> {
    List<T> parseData(String path);
}
