package ir.maktabsharif92.fruitshop.repository.impl;

import ir.maktabsharif92.fruitshop.base.repository.BaseRepositoryImpl;
import ir.maktabsharif92.fruitshop.domain.Address;
import ir.maktabsharif92.fruitshop.repository.AddressRepository;
import ir.maktabsharif92.fruitshop.repository.Database;
import ir.maktabsharif92.fruitshop.util.ArrayUtil;

public class AddressRepositoryImpl extends BaseRepositoryImpl
        implements AddressRepository {

    public AddressRepositoryImpl(Address[] entities) {
        super(entities);
    }

    @Override
    public Address[] findAllByCustomerId(Long customerId) {

//        select * from address where customer_id = :customerId

        Address[] dbAddress = (Address[]) entities;

        Address[] customerAddress = new Address[Database.DEFAULT_ARRAY_LENGTH];

        for (Address address : dbAddress) {
            if (address != null) {
                if (customerId.equals(address.getCustomerId())) {
                    customerAddress = (Address[]) ArrayUtil.increaseArrayLengthIfNecessaryAndGetNewArray(customerAddress);
                    ArrayUtil.addEntityToArray(customerAddress, address);
                }
            } else {
                break;
            }
        }

        return customerAddress;
    }

    @Override
    protected void copyTable() {
        Database.setAddresses((Address[]) entities);
    }
}
