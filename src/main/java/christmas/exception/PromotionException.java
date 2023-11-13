package christmas.exception;

public class PromotionException extends IllegalArgumentException {
    private PromotionException(Message message) {
        super(message.getMessage());
    }

    public static PromotionException of(Message message) {
        System.out.println(message.getMessage());
        return new PromotionException(message);
    }
}

