package christmas.exception;

public enum Message {
    NUMBER("유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    ORDER("유효하지 않은 주문입니다. 다시 입력해 주세요.");

    private final String content;

    Message(String message) {
        this.content = "[ERROR] " + message;
    }

    public String getMessage() {
        return content;
    }
}
