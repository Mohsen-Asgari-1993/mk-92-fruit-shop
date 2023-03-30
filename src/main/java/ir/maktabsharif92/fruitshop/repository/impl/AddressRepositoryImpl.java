package ir.maktabsharif92.fruitshop.repository.impl;

import ir.maktabsharif92.fruitshop.base.repository.BaseRepositoryImpl;
import ir.maktabsharif92.fruitshop.domain.Address;
import ir.maktabsharif92.fruitshop.repository.AddressRepository;

public class AddressRepositoryImpl extends BaseRepositoryImpl
        implements AddressRepository {

    public AddressRepositoryImpl(Address[] entities) {
        super(entities);
    }

}
