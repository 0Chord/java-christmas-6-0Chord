package christmas.service.impl;

import christmas.service.ValidateService;

public class ValidateServiceImpl implements ValidateService {
    @Override
    public void date(Integer date) {
        if (isStart(date) || isEnd(date)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isEnd(Integer date) {
        return date > 31;
    }

    private boolean isStart(Integer date) {
        return date < 1;
    }
}
