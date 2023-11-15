package christmas.constant;

public class Constants {

    public class Common {
        public static final String MENU_AND_COUNT_SPLIT = "-";
        public static final String ORDER_SPLIT = ",";
        public static final String X = "없음";

        public static final Integer ZERO = 0;
        public static final Integer MAX_ORDER_COUNT = 20;
    }

    public class Error {
        public static final String ERROR_DATE = "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.";
        public static final String ERROR_ORDER = "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.";

        public static final String ERROR_ORDER_ONLY_DRINK = "[ERROR] 음료만 주문할 수 없습니다. 다시 입력해 주세요.";
        public static final String ERROR_ORDER_EXCEED_MAX = "[ERROR] 주문 수량은 20개가 최대입니다. 다시 입력해 주세요.";
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

        public static final Integer MENU_NAME_INDEX = 0;
        public static final Integer MENU_COUNT_INDEX = 1;
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
        public static final String MINUS = "-";
        public static final String COLON = ": ";
    }

    public class DDay {
        public static final String DDAY_DISCOUNT_NAME = "크리스마스 디데이 할인";
        public static final Integer DDAY = 25;
        public static final Integer BASE_DISCOUNT = 1000;
        public static final Integer ADD_DISCOUNT = 100;
        public static final Integer ONE = 1;
    }

    public class Gift {
        public static final String GIFT_DISCOUNT_NAME = "증정 이벤트";
        public static final Integer GIFT_CHAMPAGNE_COUNT = 1;
        public static final Integer MIN_GIFT_PRICE = 120000;
        public static final Integer CHAMPAGNE_PRICE = 25000;
    }

    public class Special {
        public static final String SPECIAL_DISCOUNT_NAME = "특별 할인";
        public static final Integer SPECIAL_BASE_DISCOUNT = 1000;
    }

    public class Weekday {
        public static final String WEEKDAY_DISCOUNT_NAME = "평일 할인";
        public static final Integer WEEKDAY_BASE_DISCOUNT = 2023;
    }

    public class Weekend {
        public static final String WEEKEND_DISCOUNT_NAME = "주말 할인";
        public static final Integer WEEKEND_BASE_DISCOUNT = 2023;
    }

    public class Badge {
        public static final String STAR_NAME = "별";
        public static final String TREE_NAME = "트리";
        public static final String SANTA_NAME = "산타";

        public static final Integer STAR_MIN_PRICE = 5000;
        public static final Integer TREE_MIN_PRICE = 10000;
        public static final Integer SANTA_MIN_PRICE = 20000;
    }

    public class DayInformation {
        public static final Integer DAY_ONE = 1;
        public static final Integer DAY_TWO = 2;
        public static final Integer DAY_THREE = 3;
        public static final Integer DAY_FOUR = 4;
        public static final Integer DAY_FIVE = 5;
        public static final Integer DAY_SIX = 6;
        public static final Integer DAY_SEVEN = 7;
        public static final Integer DAY_EIGHT = 8;
        public static final Integer DAY_NINE = 9;
        public static final Integer DAY_TEN = 10;
        public static final Integer DAY_ELEVEN = 11;
        public static final Integer DAY_TWELVE = 12;
        public static final Integer DAY_THIRTEEN = 13;
        public static final Integer DAY_FOURTEEN = 14;
        public static final Integer DAY_FIFTEEN = 15;
        public static final Integer DAY_SIXTEEN = 16;
        public static final Integer DAY_SEVENTEEN = 17;
        public static final Integer DAY_EIGHTEEN = 18;
        public static final Integer DAY_NINETEEN = 19;
        public static final Integer DAY_TWENTY = 20;
        public static final Integer DAY_TWENTY_ONE = 21;
        public static final Integer DAY_TWENTY_TWO = 22;
        public static final Integer DAY_TWENTY_THREE = 23;
        public static final Integer DAY_TWENTY_FOUR = 24;
        public static final Integer DAY_TWENTY_FIVE = 25;
        public static final Integer DAY_TWENTY_SIX = 26;
        public static final Integer DAY_TWENTY_SEVEN = 27;
        public static final Integer DAY_TWENTY_EIGHT = 28;
        public static final Integer DAY_TWENTY_NINE = 29;
        public static final Integer DAY_THIRTY = 30;
        public static final Integer DAY_THIRTY_ONE = 31;
    }

    public class Menu {
        public static final String MUSHROOM_SOUP_NAME = "양송이수프";
        public static final String TAPAS_NAME = "타파스";
        public static final String CAESAR_SALAD_NAME = "시저샐러드";
        public static final String T_BONE_STAKE_NAME = "티본스테이크";
        public static final String BBQ_RIBS_NAME = "바비큐립";
        public static final String SEAFOOD_PASTA_NAME = "해산물파스타";
        public static final String CHRISTMAS_PASTA_NAME = "크리스마스파스타";
        public static final String CHOCOLATE_CAKE_NAME = "초코케이크";
        public static final String ICE_CREAM_NAME = "아이스크림";
        public static final String ZERO_COLA_NAME = "제로콜라";
        public static final String RED_WINE_NAME = "레드와인";
        public static final String CHAMPAGNE_NAME = "샴페인";
        public static final Integer MUSHROOM_SOUP_PRICE = 6000;

        public static final Integer TAPAS_PRICE = 5500;
        public static final Integer CAESAR_SALAD_PRICE = 8000;
        public static final Integer T_BONE_STAKE_PRICE = 55000;
        public static final Integer BBQ_RIBS_PRICE = 54000;
        public static final Integer SEAFOOD_PASTA_PRICE = 35000;
        public static final Integer CHRISTMAS_PASTA_PRICE = 25000;
        public static final Integer CHOCOLATE_CAKE_PRICE = 15000;
        public static final Integer ICE_CREAM_PRICE = 5000;
        public static final Integer ZERO_COLA_PRICE = 3000;
        public static final Integer RED_WINE_PRICE = 60000;
        public static final Integer CHAMPAGNE_PRICE = 25000;
    }

    public class Order {
        public static final Integer MIN_EVENT_APPLY_PRICE = 10000;
    }
}
