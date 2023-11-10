package christmas.domain.discount;

import christmas.domain.Order;

public class Gift extends Discount {
    private boolean isPresented;

    public Gift(String name) {
        super(name);
        this.isPresented = false;
    }

    @Override
    public void calculate(int date, Order order) {
        if (order.getTotalPrice() > 120000) {
            save(25000);
            present();
        }
    }

    private void present() {
        this.isPresented = true;
    }
}
