package christmas.ioadapter.impl;

import camp.nextstep.edu.missionutils.Console;
import christmas.ioadapter.InputAdapter;

public class StandardInputAdapter implements InputAdapter {
    @Override
    public String inputStream() {
        return Console.readLine();
    }
}
