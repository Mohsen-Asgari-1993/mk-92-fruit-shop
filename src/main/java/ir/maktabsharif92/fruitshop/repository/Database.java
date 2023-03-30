package ir.maktabsharif92.fruitshop.repository;

import ir.maktabsharif92.fruitshop.base.domain.User;
import ir.maktabsharif92.fruitshop.domain.*;

public abstract class Database {

    public static final int DEFAULT_ARRAY_LENGTH = 5;

    public static final User[] users = new User[DEFAULT_ARRAY_LENGTH];

    public static final Address[] addresses = new Address[DEFAULT_ARRAY_LENGTH];

    public static final Delivery[] deliveries = new Delivery[DEFAULT_ARRAY_LENGTH];

    public static final Fruit[] fruits = new Fruit[DEFAULT_ARRAY_LENGTH];

    public static final Order[] orders = new Order[DEFAULT_ARRAY_LENGTH];

    public static final OrderDelivery[] orderDeliveries = new OrderDelivery[DEFAULT_ARRAY_LENGTH];

    public static final OrderFruit[] orderFruits = new OrderFruit[DEFAULT_ARRAY_LENGTH];

    public static final Tag[] tags = new Tag[DEFAULT_ARRAY_LENGTH];


}
