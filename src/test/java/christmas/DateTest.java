package christmas;

import christmas.config.ApplicationConfig;
import christmas.service.ConvertService;
import christmas.service.ValidateService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class DateTest {

    @DisplayName("1~31사이가 아닌 다른 숫자가 입력되면 에러가 발생한다")
    @ValueSource(strings = {"32", "-1", "0"})
    @ParameterizedTest
    void date(Integer input) {
        ApplicationConfig applicationConfig = new ApplicationConfig();
        ValidateService validateService = applicationConfig.validateService();
        Assertions.assertThatThrownBy(() -> validateService.date(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1~31사이의 숫자가 입력되면 성공")
    @ValueSource(strings = {"1", "10", "31"})
    @ParameterizedTest
    void correctDate(Integer input) {
        ApplicationConfig applicationConfig = new ApplicationConfig();
        ValidateService validateService = applicationConfig.validateService();
        validateService.date(input);
    }

    @DisplayName("1~31사이가 아닌 다른 문자가 입력되면 에러가 발생한다")
    @ValueSource(strings = {"a", "#", "ten"})
    @ParameterizedTest
    void date(String input) {
        ApplicationConfig applicationConfig = new ApplicationConfig();
        ConvertService convertService = applicationConfig.convertService();
        Assertions.assertThatThrownBy(() -> convertService.stringToInteger(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
