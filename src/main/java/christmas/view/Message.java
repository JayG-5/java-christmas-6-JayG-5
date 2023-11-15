package christmas.view;

import christmas.domain.enums.Calendar;

public enum Message {
    REQUEST_DATE(String.format(
            "안녕하세요! 우테코 식당 %d월 이벤트 플래너입니다.\n%d월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)",
            Calendar.PROMOTION_MONTH.getValue(), Calendar.PROMOTION_MONTH.getValue())),
    REQUEST_MENU("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)"),
    RESPONSE_BENEFIT("%d월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!"),
    TITLE_MENU("<주문 메뉴>"),
    TITLE_PRICE("<할인 전 총주문 금액>"),
    TITLE_GIFT("<증정 메뉴>"),
    TITLE_BENEFIT("<혜택 내역>"),
    TITLE_BENEFIT_DISCOUNT("<총혜택 금액>"),
    TITLE_PAYMENT("<할인 후 예상 결제 금액>"),
    TITLE_BADGE(String.format("<%d월 이벤트 배지>",Calendar.PROMOTION_MONTH.getValue())),
    KRW_FORMATTER("%,d원");

    private final String content;

    Message(String message) {
        this.content = message;
    }

    public String getMessage() {
        return content;
    }

    public String getMessage(Object... args) {
        return String.format(content, args);
    }
}
