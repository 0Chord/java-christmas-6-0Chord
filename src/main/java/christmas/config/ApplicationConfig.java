package christmas.config;

import christmas.ioadapter.InputAdapter;
import christmas.ioadapter.OutputAdapter;
import christmas.ioadapter.impl.StandardInputAdapter;
import christmas.ioadapter.impl.StandardOutputAdapter;
import christmas.process.Process;
import christmas.process.controller.BenefitController;
import christmas.process.controller.CalendarController;
import christmas.process.controller.FoodController;
import christmas.process.controller.OrderController;
import christmas.process.controller.PrintController;
import christmas.process.controller.TotalAmountController;
import christmas.process.impl.OrderProcess;
import christmas.service.ConvertService;
import christmas.service.DiscountService;
import christmas.service.ValidateService;
import christmas.service.impl.ConvertServiceImpl;
import christmas.service.impl.DiscountServiceImpl;
import christmas.service.impl.ValidateServiceImpl;

public class ApplicationConfig {

    public InputAdapter inputAdapter() {
        return new StandardInputAdapter();
    }

    public OutputAdapter outputAdapter() {
        return new StandardOutputAdapter();
    }

    public ConvertService convertService() {
        return new ConvertServiceImpl();
    }

    public ValidateService validateService() {
        return new ValidateServiceImpl();
    }

    public DiscountService discountService() {
        return new DiscountServiceImpl();
    }

    public CalendarController calendarController() {
        return new CalendarController(inputAdapter(), convertService(), validateService(), outputAdapter());
    }

    public FoodController foodController() {
        return new FoodController();
    }

    public OrderController orderController() {
        return new OrderController(inputAdapter(), convertService(), validateService(), outputAdapter());
    }

    public PrintController printController() {
        return new PrintController(outputAdapter(), convertService());
    }

    public TotalAmountController totalAmountController() {
        return new TotalAmountController();
    }

    public BenefitController benefitController() {
        return new BenefitController(discountService());
    }

    public Process process() {
        return new OrderProcess(printController(), orderController(), foodController(), calendarController(),
                totalAmountController(), benefitController());
    }
}
