package ir.maktabsharif92.fruitshop.service;

import ir.maktabsharif92.fruitshop.base.service.BaseService;
import ir.maktabsharif92.fruitshop.domain.Address;

public interface AddressService extends BaseService {

    Address[] findAllByCustomerId(Long customerId);

}
