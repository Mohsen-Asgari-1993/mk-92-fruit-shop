package ir.maktabsharif92.fruitshop.repository;

import ir.maktabsharif92.fruitshop.base.repository.BaseRepository;
import ir.maktabsharif92.fruitshop.domain.Address;

public interface AddressRepository extends BaseRepository {

    Address[] findAllByCustomerId(Long customerId);

}
