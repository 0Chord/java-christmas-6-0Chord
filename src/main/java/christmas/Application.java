package christmas;

import christmas.config.ApplicationConfig;
import christmas.process.Process;

public class Application {
    public static void main(String[] args) {
        ApplicationConfig appConfig = new ApplicationConfig();
        Process process = appConfig.process();
        process.play();
    }


}
