package ir.maktabsharif92.fruitshop.repository;

import ir.maktabsharif92.fruitshop.base.domain.User;
import ir.maktabsharif92.fruitshop.domain.*;

public class Database {

    private static final int DEFAULT_ARRAY_LENGTH = 5;

    private final User[] users = new User[DEFAULT_ARRAY_LENGTH];

    private final Address[] addresses = new Address[DEFAULT_ARRAY_LENGTH];

    private final Delivery[] deliveries = new Delivery[DEFAULT_ARRAY_LENGTH];

    private final Fruit[] fruits = new Fruit[DEFAULT_ARRAY_LENGTH];

    private final Order[] orders = new Order[DEFAULT_ARRAY_LENGTH];

    private final OrderDelivery[] orderDeliveries = new OrderDelivery[DEFAULT_ARRAY_LENGTH];

    private final OrderFruit[] orderFruits = new OrderFruit[DEFAULT_ARRAY_LENGTH];

    private final Tag[] tags = new Tag[DEFAULT_ARRAY_LENGTH];


}
