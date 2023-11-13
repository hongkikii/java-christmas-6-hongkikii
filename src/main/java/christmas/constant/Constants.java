package christmas.constant;

public class Constants {

    public class Common {
        public static final String MENU_AND_NUMBER_SPLIT = "-";
        public static final String ORDER_SPLIT = ",";
        public static final Integer ZERO = 0;
        public static final Integer MAX_ORDER_COUNT = 20;
    }

    public class InputView {
        public static final String INTRODUCE = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";
        public static final String ASK_DATE = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";
        public static final String ASK_ORDER = "주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)";

        public static final String ORDER = "order";
        public static final String DATE = "date";
        public static final String ORDER_REGEX = "^[가-힣]+-\\d+(,[가-힣]+-\\d+)*$";

        public static final Integer DECEMBER_START = 1;
        public static final Integer DECEMBER_END = 31;
        public static final Integer MIN_ORDER_COUNT = 1;
    }

    public class OutputView {
        public static final String HEADER_FRONT = "12월 ";
        public static final String HEADER_BACK = "일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!";

        public static final String ORDER_MENU = "<주문 메뉴>";
        public static final String TOTAL_PRICE = "<할인 전 총주문 금액>";
        public static final String GIFT_MENU = "<증정 메뉴>";
        public static final String BENEFIT_LIST = "<혜택 내역>";
        public static final String BENEFIT_PRICE = "<총혜택 금액>";
        public static final String PAYMENT_PRICE = "<할인 후 예상 결제 금액>";
        public static final String BADGE = "<12월 이벤트 배지>";

        public static final String SPACING = " ";
        public static final String MENU_COUNT_UNIT = "개";
        public static final String WON_FORMAT = "###,###";
        public static final String WON = "원";
        public static final String NONE = "없음";
        public static final String MINUS = "-";
        public static final String COLON = ": ";
    }

    public class Order {
        public static final Integer MIN_EVENT_APPLY_PRICE = 10000;
    }

    public class DDay {
        public static final String DDAY_NAME = "크리스마스 디데이 할인";
        public static final Integer DDAY = 25;
        public static final Integer BASE_DISCOUNT = 1000;
        public static final Integer ADD_DISCOUNT = 100;
    }

    public class Gift {
        public static final String GIFT_NAME = "증정 이벤트";
        public static final Integer GIFT_CHAMPAGNE_NUMBER = 1;
        public static final Integer MIN_GIFT_PRICE = 120000;
        public static final Integer CHAMPAGNE_PRICE = 25000;
    }

    public class Error {
        public static final String ERROR_DATE = "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.";
        public static final String ERROR_ORDER = "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.";

        public static final String ERROR_ORDER_ONLY_DRINK = "[ERROR] 음료만 주문할 수 없습니다. 다시 입력해 주세요.";
        public static final String ERROR_ORDER_EXCEED_MAX = "[ERROR] 주문 수량은 20개가 최대입니다. 다시 입력해 주세요.";
    }
}
