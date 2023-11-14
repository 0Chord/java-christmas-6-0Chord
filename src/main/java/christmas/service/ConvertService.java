package christmas.service;

import java.util.List;

public interface ConvertService {
    Integer stringToInteger(String inputStream);

    List<String> stringToList(String inputStream);

    String longToString(long value);
}
