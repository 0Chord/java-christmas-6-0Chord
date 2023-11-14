package christmas.service.impl;

import static christmas.constants.TypeConstants.COMMAS;
import static christmas.constants.TypeConstants.UNIT_OF_MONEY;

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
        return Arrays.asList(inputStream.split(COMMAS.getName()));
    }

    @Override
    public String longToString(long value) {
        DecimalFormat decimalFormat = new DecimalFormat(UNIT_OF_MONEY.getName());
        return decimalFormat.format(value);
    }
}
