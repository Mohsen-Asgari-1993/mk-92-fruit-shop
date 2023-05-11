package ir.maktabsharif92.fruitshop.util;

import ir.maktabsharif92.fruitshop.repository.WalletRepository;
import ir.maktabsharif92.fruitshop.repository.impl.WalletRepositoryImpl;
import ir.maktabsharif92.fruitshop.service.WalletService;
import ir.maktabsharif92.fruitshop.service.impl.WalletServiceImpl;

import java.sql.SQLException;

public class ApplicationContext {

    private static WalletRepository walletRepository;

    private static WalletService walletService;

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
