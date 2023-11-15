package christmas.domain;

import static christmas.domain.DayInformation.SpecialType.*;
import static christmas.domain.DayInformation.WeekType.*;

import java.util.Arrays;

public enum DayInformation {

    ONE(1, WEEKEND, NON_SPECIAL),
    TWO(2, WEEKEND, NON_SPECIAL),
    THREE(3, WEEKDAY, SPECIAL),
    FOUR(4, WEEKDAY, NON_SPECIAL),
    FIVE(5, WEEKDAY, NON_SPECIAL),
    SIX(6, WEEKDAY, NON_SPECIAL),
    SEVEN(7, WEEKDAY, NON_SPECIAL),
    EIGHT(8, WEEKEND, NON_SPECIAL),
    NINE(9, WEEKEND, NON_SPECIAL),
    TEN(10, WEEKDAY, SPECIAL),
    ELEVEN(11, WEEKDAY, NON_SPECIAL),
    TWELVE(12, WEEKDAY, NON_SPECIAL),
    THIRTEEN(13, WEEKDAY, NON_SPECIAL),
    FOURTEEN(14, WEEKDAY, NON_SPECIAL),
    FIFTEEN(15, WEEKEND, NON_SPECIAL),
    SIXTEEN(16, WEEKEND, NON_SPECIAL),
    SEVENTEEN(17, WEEKDAY, SPECIAL),
    EIGHTEEN(18, WEEKDAY, NON_SPECIAL),
    NINETEEN(19, WEEKDAY, NON_SPECIAL),
    TWENTY(20, WEEKDAY, NON_SPECIAL),
    TWENTY_ONE(21, WEEKDAY, NON_SPECIAL),
    TWENTY_TWO(22, WEEKEND, NON_SPECIAL),
    TWENTY_THREE(23, WEEKEND, NON_SPECIAL),
    TWENTY_FOUR(24, WEEKDAY, SPECIAL),
    TWENTY_FIVE(25, WEEKDAY, SPECIAL),
    TWENTY_SIX(26, WEEKDAY, NON_SPECIAL),
    TWENTY_SEVEN(27, WEEKDAY, NON_SPECIAL),
    TWENTY_EIGHT(28, WEEKDAY, NON_SPECIAL),
    TWENTY_NINE(29, WEEKEND, NON_SPECIAL),
    THIRTY(30, WEEKEND, NON_SPECIAL),
    THIRTY_ONE(31, WEEKDAY, SPECIAL);

    private final int date;
    private final WeekType weekType;
    private final SpecialType specialType;

    DayInformation(int date, WeekType weekType, SpecialType specialType) {
        this.date = date;
        this.weekType = weekType;
        this.specialType = specialType;
    }

    public static DayInformation getDayInformation(int compareDate) {
        return Arrays.stream(DayInformation.values())
                .filter(dayInformation -> dayInformation.date == compareDate)
                .findFirst()
                .orElse(null);
    }

    public WeekType getWeekType() {
        return this.weekType;
    }

    public SpecialType getSpecialType() {
        return this.specialType;
    }

    public enum WeekType {
        WEEKDAY,
        WEEKEND
    }

    public enum SpecialType {
        SPECIAL,
        NON_SPECIAL
    }
}
