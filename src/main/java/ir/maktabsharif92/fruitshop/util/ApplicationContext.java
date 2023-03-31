package ir.maktabsharif92.fruitshop.util;

import ir.maktabsharif92.fruitshop.repository.AddressRepository;
import ir.maktabsharif92.fruitshop.repository.Database;
import ir.maktabsharif92.fruitshop.repository.ProvinceRepository;
import ir.maktabsharif92.fruitshop.repository.impl.AddressRepositoryImpl;
import ir.maktabsharif92.fruitshop.repository.impl.ProvinceRepositoryImpl;

import java.sql.SQLException;

public class ApplicationContext {

    private static AddressRepository addressRepository;

    private static ProvinceRepository provinceRepository;

    public static AddressRepository getAddressRepository() {
        if (addressRepository == null) {
            addressRepository =
                    new AddressRepositoryImpl(Database.getAddresses());
        }
        return addressRepository;
    }

    public static ProvinceRepository getProvinceRepository() throws SQLException {
        if (provinceRepository == null) {
            provinceRepository =
                    new ProvinceRepositoryImpl(
                            Datasource.getConnection()
                    );
        }
        return provinceRepository;
    }
}
