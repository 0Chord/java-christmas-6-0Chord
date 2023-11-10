package christmas.config;

import christmas.ioadapter.InputAdapter;
import christmas.ioadapter.OutputAdapter;
import christmas.ioadapter.impl.StandardInputAdapter;
import christmas.ioadapter.impl.StandardOutputAdapter;

public class ApplicationConfig {

    public InputAdapter inputAdapter() {
        return new StandardInputAdapter();
    }

    public OutputAdapter outputAdapter() {
        return new StandardOutputAdapter();
    }
}
