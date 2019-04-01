package practice3;

import java.math.BigDecimal;
import java.util.List;

public class Order {

    private List<OrderLineItem> orderLineItemList;
    private List<BigDecimal> discounts;
    private BigDecimal tax;

    public Order(List<OrderLineItem> orderLineItemList, List<BigDecimal> discounts) {
        this.orderLineItemList = orderLineItemList;
        this.discounts = discounts;
        this.tax = new BigDecimal(0.1);
    }

    public BigDecimal calculate() {
        return new OrderProfit().invoke();
    }

    private class OrderProfit {
        public BigDecimal invoke() {
            BigDecimal subTotal = new BigDecimal(0);

            // Total up line items
            for (OrderLineItem lineItem : orderLineItemList) {
                subTotal = subTotal.add(lineItem.getPrice());
            }

            // Subtract discounts
            for (BigDecimal discount : discounts) {
                subTotal = subTotal.subtract(discount);
            }

            // calculate tax
            BigDecimal tax = subTotal.multiply(Order.this.tax);

            // calculate GrandTotal
            BigDecimal grandTotal = subTotal.add(tax);

            return grandTotal;
        }
    }
}
