package ir.maktabsharif92.fruitshop.domain;

import ir.maktabsharif92.fruitshop.base.domain.Entity;
import ir.maktabsharif92.fruitshop.domain.enumeration.OrderStatus;

public class Order extends Entity {

    //    ManyToOne
    private Customer customer;

    private String code;

    private OrderStatus status;

    private OrderFruit[] fruits;

    private OrderDelivery delivery;

    private Long totalPrice;

    public Order() {
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public OrderFruit[] getFruits() {
        return fruits;
    }

    public void setFruits(OrderFruit[] fruits) {
        this.fruits = fruits;
    }

    public OrderDelivery getDelivery() {
        return delivery;
    }

    public void setDelivery(OrderDelivery delivery) {
        this.delivery = delivery;
    }

    public Long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Long totalPrice) {
        this.totalPrice = totalPrice;
    }
}
