package christmas.process.controller;

import christmas.domain.Calendar;
import christmas.ioadapter.InputAdapter;
import christmas.ioadapter.OutputAdapter;
import christmas.message.ErrorMessage;
import christmas.service.ConvertService;
import christmas.service.ValidateService;

public class CalendarController {

    private final InputAdapter inputAdapter;
    private final ConvertService convertService;
    private final ValidateService validateService;
    private final OutputAdapter outputAdapter;

    public CalendarController(InputAdapter inputAdapter, ConvertService convertService, ValidateService validateService,
                              OutputAdapter outputAdapter) {
        this.inputAdapter = inputAdapter;
        this.convertService = convertService;
        this.validateService = validateService;
        this.outputAdapter = outputAdapter;
    }

    public Calendar make() {
        while (true) {
            try {
                String inputStream = inputAdapter.inputStream();
                Integer date = convertService.stringToInteger(inputStream);
                validateService.date(date);
                return new Calendar(date);
            } catch (IllegalArgumentException exception) {
                ErrorMessage date = ErrorMessage.DATE;
                outputAdapter.printMessage(date.getMessage());
            }
        }
    }
}
