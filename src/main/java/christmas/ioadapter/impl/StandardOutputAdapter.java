package christmas.ioadapter.impl;

import christmas.ioadapter.OutputAdapter;

public class StandardOutputAdapter implements OutputAdapter {
    @Override
    public void printMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void printNewline() {
        System.out.println();
    }
}
