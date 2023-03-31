package ir.maktabsharif92.fruitshop.service.impl;

import ir.maktabsharif92.fruitshop.base.service.BaseServiceImpl;
import ir.maktabsharif92.fruitshop.domain.Address;
import ir.maktabsharif92.fruitshop.repository.AddressRepository;
import ir.maktabsharif92.fruitshop.service.AddressService;

public class AddressServiceImpl extends BaseServiceImpl implements AddressService {

    protected AddressServiceImpl(AddressRepository repository) {
        super(repository);
    }

    @Override
    public Address[] findAllByCustomerId(Long customerId) {
        Address[] addresses = ((AddressRepository) repository).findAllByCustomerId(customerId);
//        TODO add ur logic
        return addresses;
    }

}
