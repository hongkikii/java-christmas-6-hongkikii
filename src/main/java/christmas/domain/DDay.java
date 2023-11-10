package christmas.domain;

public class DDay extends Discount{

    public DDay(String name) {
        super(name);
    }

    @Override
    public void calculate(int date, Order order) {
        if (date < 25) {
            save(date - 1 + 1000);
        }
    }
}
