package ir.maktabsharif92.fruitshop;

import ir.maktabsharif92.fruitshop.domain.Wallet;
import ir.maktabsharif92.fruitshop.service.WalletService;
import ir.maktabsharif92.fruitshop.util.ApplicationContext;
import ir.maktabsharif92.fruitshop.util.Datasource;

import java.sql.SQLException;

public class FruitShopApplication {

    public static void main(String[] args) throws SQLException {

        WalletService walletService = ApplicationContext.getWalletService();

        initNewWallet(walletService, new Wallet(
                15L,
                1000L,
                1000L,
                0L
        ));

        walletService.getAll().forEach(System.out::println);

        Datasource.getConnection().close();

    }

    private static void initNewWallet(WalletService walletService, Wallet wallet) throws SQLException {
        walletService.save(
                wallet
        );
    }

}
