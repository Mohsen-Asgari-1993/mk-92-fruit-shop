package ir.maktabsharif92.fruitshop.repository.impl;

import ir.maktabsharif92.fruitshop.base.repository.BaseRepositoryImpl;
import ir.maktabsharif92.fruitshop.domain.Delivery;
import ir.maktabsharif92.fruitshop.repository.Database;
import ir.maktabsharif92.fruitshop.repository.DeliveryRepository;

public class DeliveryRepositoryImpl extends BaseRepositoryImpl
        implements DeliveryRepository {

    public DeliveryRepositoryImpl(Delivery[] entities) {
        super(entities);
    }


    @Override
    protected void copyTable() {
        Database.setDeliveries((Delivery[]) entities);
    }

}
