package ir.maktabsharif92.fruitshop.util;

import ir.maktabsharif92.fruitshop.repository.ClientRepository;
import ir.maktabsharif92.fruitshop.repository.ManagerRepository;
import ir.maktabsharif92.fruitshop.repository.UserRepository;
import ir.maktabsharif92.fruitshop.repository.WalletRepository;
import ir.maktabsharif92.fruitshop.repository.impl.ClientRepositoryImpl;
import ir.maktabsharif92.fruitshop.repository.impl.ManagerRepositoryImpl;
import ir.maktabsharif92.fruitshop.repository.impl.UserRepositoryImpl;
import ir.maktabsharif92.fruitshop.repository.impl.WalletRepositoryImpl;
import ir.maktabsharif92.fruitshop.service.ClientService;
import ir.maktabsharif92.fruitshop.service.ManagerService;
import ir.maktabsharif92.fruitshop.service.UserService;
import ir.maktabsharif92.fruitshop.service.WalletService;
import ir.maktabsharif92.fruitshop.service.impl.ClientServiceImpl;
import ir.maktabsharif92.fruitshop.service.impl.ManagerServiceImpl;
import ir.maktabsharif92.fruitshop.service.impl.UserServiceImpl;
import ir.maktabsharif92.fruitshop.service.impl.WalletServiceImpl;

import java.sql.SQLException;

public class ApplicationContext {

    private static WalletRepository walletRepository;

    private static WalletService walletService;

    private static UserRepository userRepository;

    private static UserService userService;

    private static ManagerRepository managerRepository;

    private static ManagerService managerService;

    private static ClientRepository clientRepository;

    private static ClientService clientService;

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

    public static UserRepository getUserRepository() throws SQLException {
        if (userRepository == null) {
            userRepository = new UserRepositoryImpl(
                    Datasource.getConnection()
            );
        }
        return userRepository;
    }

    public static UserService getUserService() throws SQLException {
        if (userService == null) {
            userService = new UserServiceImpl(
                    getUserRepository()
            );
        }
        return userService;
    }

    public static ManagerRepository getManagerRepository() throws SQLException {
        if (managerRepository == null) {
            managerRepository = new ManagerRepositoryImpl(
                    Datasource.getConnection()
            );
        }
        return managerRepository;
    }

    public static ManagerService getManagerService() throws SQLException {
        if (managerService == null) {
            managerService = new ManagerServiceImpl(
                    getManagerRepository()
            );
        }
        return managerService;
    }

    public static ClientRepository getClientRepository() throws SQLException {
        if (clientRepository == null) {
            clientRepository = new ClientRepositoryImpl(
                    Datasource.getConnection()
            );
        }
        return clientRepository;
    }

    public static ClientService getClientService() throws SQLException {
        if (clientService == null) {
            clientService = new ClientServiceImpl(
                    getClientRepository()
            );
        }
        return clientService;
    }
}
