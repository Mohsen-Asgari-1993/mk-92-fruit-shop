package ir.maktabsharif92.fruitshop.util;

import ir.maktabsharif92.fruitshop.repository.*;
import ir.maktabsharif92.fruitshop.repository.impl.AddressRepositoryImpl;
import ir.maktabsharif92.fruitshop.repository.impl.CityRepositoryImpl;
import ir.maktabsharif92.fruitshop.repository.impl.ProvinceRepositoryImpl;
import ir.maktabsharif92.fruitshop.repository.impl.WalletRepositoryImpl;
import ir.maktabsharif92.fruitshop.service.WalletService;
import ir.maktabsharif92.fruitshop.service.impl.WalletServiceImpl;

import java.sql.SQLException;

public class ApplicationContext {

    private static AddressRepository addressRepository;

    private static ProvinceRepository provinceRepository;

    private static CityRepository cityRepository;

    private static WalletRepository walletRepository;

    private static WalletService walletService;

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

    public static CityRepository getCityRepository() throws SQLException {
        if (cityRepository == null) {
            cityRepository =
                    new CityRepositoryImpl(
                            Datasource.getConnection()
                    );
        }
        return cityRepository;
    }

    public static WalletRepository getWalletRepository() throws SQLException {
        if (walletRepository == null) {
            walletRepository =
                    new WalletRepositoryImpl(
                            Datasource.getConnection()
                    );
        }
        return walletRepository;
    }

    public static WalletService getWalletService() throws SQLException {
        if (walletService == null) {
            walletService = new WalletServiceImpl(
                    getWalletRepository()
            );
        }
        return walletService;
    }
}
