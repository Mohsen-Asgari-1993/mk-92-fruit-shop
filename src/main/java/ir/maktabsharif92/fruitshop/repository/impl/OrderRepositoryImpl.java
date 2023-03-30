package ir.maktabsharif92.fruitshop.repository.impl;

import ir.maktabsharif92.fruitshop.base.repository.BaseRepositoryImpl;
import ir.maktabsharif92.fruitshop.domain.Order;
import ir.maktabsharif92.fruitshop.repository.OrderRepository;

public class OrderRepositoryImpl extends BaseRepositoryImpl
        implements OrderRepository {

    public OrderRepositoryImpl(Order[] entities) {
        super(entities);
    }

}
