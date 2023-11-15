package christmas.domain;

import static christmas.constant.Constants.DayInformation.*;
import static christmas.domain.DayInformation.SpecialType.*;
import static christmas.domain.DayInformation.WeekType.*;

import christmas.constant.Constants;
import java.util.Arrays;

public enum DayInformation {

    ONE(DAY_ONE, WEEKEND, NON_SPECIAL),
    TWO(DAY_TWO, WEEKEND, NON_SPECIAL),
    THREE(DAY_THREE, WEEKDAY, SPECIAL),
    FOUR(DAY_FOUR, WEEKDAY, NON_SPECIAL),
    FIVE(DAY_FIVE, WEEKDAY, NON_SPECIAL),
    SIX(DAY_SIX, WEEKDAY, NON_SPECIAL),
    SEVEN(DAY_SEVEN, WEEKDAY, NON_SPECIAL),
    EIGHT(DAY_EIGHT, WEEKEND, NON_SPECIAL),
    NINE(DAY_NINE, WEEKEND, NON_SPECIAL),
    TEN(DAY_TEN, WEEKDAY, SPECIAL),
    ELEVEN(DAY_ELEVEN, WEEKDAY, NON_SPECIAL),
    TWELVE(DAY_TWELVE, WEEKDAY, NON_SPECIAL),
    THIRTEEN(DAY_THIRTEEN, WEEKDAY, NON_SPECIAL),
    FOURTEEN(DAY_FOURTEEN, WEEKDAY, NON_SPECIAL),
    FIFTEEN(DAY_FIFTEEN, WEEKEND, NON_SPECIAL),
    SIXTEEN(DAY_SIXTEEN, WEEKEND, NON_SPECIAL),
    SEVENTEEN(DAY_SEVENTEEN, WEEKDAY, SPECIAL),
    EIGHTEEN(DAY_EIGHTEEN, WEEKDAY, NON_SPECIAL),
    NINETEEN(DAY_NINETEEN, WEEKDAY, NON_SPECIAL),
    TWENTY(DAY_TWENTY, WEEKDAY, NON_SPECIAL),
    TWENTY_ONE(DAY_TWENTY_ONE, WEEKDAY, NON_SPECIAL),
    TWENTY_TWO(DAY_TWENTY_TWO, WEEKEND, NON_SPECIAL),
    TWENTY_THREE(DAY_TWENTY_THREE, WEEKEND, NON_SPECIAL),
    TWENTY_FOUR(DAY_TWENTY_FOUR, WEEKDAY, SPECIAL),
    TWENTY_FIVE(DAY_TWENTY_FIVE, WEEKDAY, SPECIAL),
    TWENTY_SIX(DAY_TWENTY_SIX, WEEKDAY, NON_SPECIAL),
    TWENTY_SEVEN(DAY_TWENTY_SEVEN, WEEKDAY, NON_SPECIAL),
    TWENTY_EIGHT(DAY_TWENTY_EIGHT, WEEKDAY, NON_SPECIAL),
    TWENTY_NINE(DAY_TWENTY_NINE, WEEKEND, NON_SPECIAL),
    THIRTY(DAY_THIRTY, WEEKEND, NON_SPECIAL),
    THIRTY_ONE(DAY_THIRTY_ONE, WEEKDAY, SPECIAL);

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
