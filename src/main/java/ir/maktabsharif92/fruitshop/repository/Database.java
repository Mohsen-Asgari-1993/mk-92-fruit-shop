package ir.maktabsharif92.fruitshop.repository;

import ir.maktabsharif92.fruitshop.base.domain.User;
import ir.maktabsharif92.fruitshop.domain.*;

public abstract class Database {

    public static final int DEFAULT_ARRAY_LENGTH = 5;

    private static User[] users = new User[DEFAULT_ARRAY_LENGTH];

    private static Address[] addresses = new Address[DEFAULT_ARRAY_LENGTH];

    private static Delivery[] deliveries = new Delivery[DEFAULT_ARRAY_LENGTH];

    private static Fruit[] fruits = new Fruit[DEFAULT_ARRAY_LENGTH];

    private static Order[] orders = new Order[DEFAULT_ARRAY_LENGTH];

    private static OrderDelivery[] orderDeliveries = new OrderDelivery[DEFAULT_ARRAY_LENGTH];

    private static OrderFruit[] orderFruits = new OrderFruit[DEFAULT_ARRAY_LENGTH];

    private static Tag[] tags = new Tag[DEFAULT_ARRAY_LENGTH];

    public static User[] getUsers() {
        return users;
    }

    public static void setUsers(User[] users) {
        Database.users = users;
    }

    public static Address[] getAddresses() {
        return addresses;
    }

    public static void setAddresses(Address[] addresses) {
        Database.addresses = addresses;
    }

    public static Delivery[] getDeliveries() {
        return deliveries;
    }

    public static void setDeliveries(Delivery[] deliveries) {
        Database.deliveries = deliveries;
    }

    public static Fruit[] getFruits() {
        return fruits;
    }

    public static void setFruits(Fruit[] fruits) {
        Database.fruits = fruits;
    }

    public static Order[] getOrders() {
        return orders;
    }

    public static void setOrders(Order[] orders) {
        Database.orders = orders;
    }

    public static OrderDelivery[] getOrderDeliveries() {
        return orderDeliveries;
    }

    public static void setOrderDeliveries(OrderDelivery[] orderDeliveries) {
        Database.orderDeliveries = orderDeliveries;
    }

    public static OrderFruit[] getOrderFruits() {
        return orderFruits;
    }

    public static void setOrderFruits(OrderFruit[] orderFruits) {
        Database.orderFruits = orderFruits;
    }

    public static Tag[] getTags() {
        return tags;
    }

    public static void setTags(Tag[] tags) {
        Database.tags = tags;
    }
}
