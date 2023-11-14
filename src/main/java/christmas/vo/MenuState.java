package christmas.vo;

import java.util.List;

public final class MenuState {
    private final List<String> menu;

    public MenuState(List<String> menu) {
        this.menu = menu;
    }

    public String name() {
        return menu.get(0);
    }

    public Long quantity() {
        return Long.parseLong(menu.get(1));
    }
}
