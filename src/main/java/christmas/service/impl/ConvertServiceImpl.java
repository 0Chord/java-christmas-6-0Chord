package christmas.service.impl;

import christmas.service.ConvertService;

public class ConvertServiceImpl implements ConvertService {
    @Override
    public Integer stringToInteger(String inputStream) {
        return Integer.parseInt(inputStream);
    }
}
