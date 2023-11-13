package christmas.constant;

public class Constants {

    public class InputView {
        public static final String INTRODUCE = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";
        public static final String ASK_DATE = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";
        public static final String ASK_ORDER = "주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)";

        public static final String ORDER = "order";
        public static final String DATE = "date";

        public static final String MENU_AND_NUMBER_SPLIT = "-";
        public static final String ORDER_SPLIT = ",";
        public static final String ORDER_REGEX = "^[가-힣]+-\\d+(,[가-힣]+-\\d+)*$";

        public static final Integer DECEMBER_START = 1;
        public static final Integer DECEMBER_END = 31;
        public static final Integer MIN_ORDER_COUNT = 1;
        public static final Integer MAX_ORDER_COUNT = 20;
    }

    public class Error {
        public static final String ERROR_DATE = "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.";
        public static final String ERROR_ORDER = "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.";
    }
}
