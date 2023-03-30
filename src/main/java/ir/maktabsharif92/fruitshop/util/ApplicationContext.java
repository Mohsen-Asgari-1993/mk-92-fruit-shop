package ir.maktabsharif92.fruitshop.util;

import ir.maktabsharif92.fruitshop.repository.AddressRepository;
import ir.maktabsharif92.fruitshop.repository.Database;
import ir.maktabsharif92.fruitshop.repository.impl.AddressRepositoryImpl;

public class ApplicationContext {

    private static AddressRepository addressRepository;

    public static AddressRepository getAddressRepository() {
        if (addressRepository == null) {
            addressRepository =
                    new AddressRepositoryImpl(Database.addresses);
        }
        return addressRepository;
    }
}
