package christmas.service.impl;

import christmas.service.ConvertService;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;

public class ConvertServiceImpl implements ConvertService {
    @Override
    public Integer stringToInteger(String inputStream) {
        return Integer.parseInt(inputStream);
    }

    @Override
    public List<String> stringToList(String inputStream) {
        return Arrays.asList(inputStream.split(","));
    }

    @Override
    public String longToString(long value) {
        DecimalFormat decimalFormat = new DecimalFormat("###,###원");
        return decimalFormat.format(value);
    }
}
