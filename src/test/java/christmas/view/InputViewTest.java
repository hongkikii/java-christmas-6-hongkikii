package christmas.view;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import christmas.Application;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewTest extends NsTest {
    private String normalDate;
    private String normalMenu;

    @BeforeEach
    void setUp() {
        normalDate = "23";
        normalMenu = "타파스-1,제로콜라-1";
    }

    @DisplayName("날짜를 정상적으로 저장한다.")
    @Test
    void saveDate() {
        executeNormalDate("1");
        executeNormalDate("15");
        executeNormalDate("31");
    }

    void executeNormalDate(String testDate) {
        run(testDate, normalMenu);
        assertThat(output()).contains("12월 " + testDate + "일");
    }

    @DisplayName("날짜가 숫자가 아닌 경우 예외가 발생한다.")
    @Test
    void saveNoNumberDate() {
        executeAbnormalDate("a");
        executeAbnormalDate("-");
        executeAbnormalDate("가");
        executeAbnormalDate("1a");
    }

    @DisplayName("날짜가 1 이상 31 이하의 숫자가 아닐 경우 예외가 발생한다.")
    @Test
    void saveNoBoundaryDate() {
        executeAbnormalDate("0");
        executeAbnormalDate("32");
    }

    private void executeAbnormalDate(String testDate) {
        runException(testDate, normalMenu);
        assertThat(output()).contains("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
    }

    @DisplayName("메뉴를 정상적으로 저장한다.")
    @Test
    void saveMenu() {
        run(normalDate, "타파스-1,레드와인-1");
        assertThat(output()).contains("타파스 1개");
        assertThat(output()).contains("레드와인 1개");
    }

    @DisplayName("메뉴가 메뉴판에 없는 경우 예외가 발생한다.")
    @Test
    void saveNoContainMenu() {
        runException(normalDate, "봉골레파스타-1,레드와인-1");
        assertThat(output()).contains("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

    @DisplayName("메뉴의 개수가 숫자가 아닌 경우 예외가 발생한다.")
    @Test
    void saveNoCountMenu() {
        executeAbnormalNumberMenu("a");
        executeAbnormalNumberMenu("2a");
        executeAbnormalNumberMenu("-");
        executeAbnormalNumberMenu("타파스");
    }

    @DisplayName("메뉴의 개수가 1 이상의 숫자가 아닌 경우 예외가 발생한다.")
    @Test
    void saveBelowOneCountMenu() {
        executeAbnormalNumberMenu("0");
    }

    void executeAbnormalNumberMenu(String notNumber) {
        runException(normalDate, "타파스-" + notNumber + ",레드와인-1");
        assertThat(output()).contains("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

    @DisplayName("메뉴를 비롯한 주문 형식이 예시와 다른 경우 예외가 발생한다.")
    @Test
    void saveNoFormMenu() {
        executeNoFormMenu("[타파스]-1,[레드와인]-1");
        executeNoFormMenu(" 타파스-1,레드와인-1");
        executeNoFormMenu("타파스-1, 레드와인-1");
        executeNoFormMenu("타파스-1,레드와인-1 ");
    }

    void executeNoFormMenu(String order) {
        runException(normalDate, order);
        assertThat(output()).contains("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

    @DisplayName("중복 메뉴를 입력한 경우 예외가 발생한다.")
    @Test
    void saveDuplicateMenu() {
        runException(normalDate, "타파스-1,타파스-1,레드와인-1");
        assertThat(output()).contains("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
