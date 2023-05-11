package ir.maktabsharif92.fruitshop.repository.impl;

import ir.maktabsharif92.fruitshop.base.repository.BaseUserGenericRepositoryImpl;
import ir.maktabsharif92.fruitshop.domain.Client;
import ir.maktabsharif92.fruitshop.repository.ClientRepository;

import java.sql.Connection;

public class ClientRepositoryImpl
        extends BaseUserGenericRepositoryImpl<Client>
        implements ClientRepository {

    public ClientRepositoryImpl(Connection connection) {
        super(connection);
    }

}
