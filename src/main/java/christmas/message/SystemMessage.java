package christmas.message;

public enum SystemMessage {
    START("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다."),
    DATE("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)"),
    SELECT("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)"),
    INTRODUCTION("일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!"),
    DECEMBER("12월 "),
    ORDER_MENU("<주문 메뉴>"),
    TOTAL_ORDER_AMOUNT("<할인 전 총주문 금액>"),
    GIVEAWAY_MENU("<증정 메뉴>"),
    BENEFIT_DETAILS("<혜택 내역>"),
    TOTAL_BENEFIT_AMOUNT("<총혜택 금액>"),
    EXPECTED_PAYMENT_AMOUNT("<할인 후 예상 결제 금액>"),
    BADGE("<12월 이벤트 배지>"),
    GIVEAWAY("샴페인 1개"),
    NO_EXIST("없음"),
    D_DAY_DISCOUNT("크리스마스 디데이 할인: "),
    WEEKDAY_DISCOUNT("평일 할인: "),
    WEEKEND_DISCOUNT("주말 할인: "),
    SPECIAL_DISCOUNT("특별 할인: "),
    EVENT("증정 이벤트: ")
    ;
    private final String message;

    SystemMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String event(int date) {
        return DECEMBER.getMessage() + date + INTRODUCTION.getMessage();
    }

    public String menu(long totalAmount) {
        if (totalAmount >= 120000) {
            return GIVEAWAY.getMessage();
        }
        return NO_EXIST.getMessage();
    }

}
