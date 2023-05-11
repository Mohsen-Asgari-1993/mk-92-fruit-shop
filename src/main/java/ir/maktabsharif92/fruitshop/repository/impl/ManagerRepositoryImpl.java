package ir.maktabsharif92.fruitshop.repository.impl;

import ir.maktabsharif92.fruitshop.base.repository.BaseUserGenericRepositoryImpl;
import ir.maktabsharif92.fruitshop.domain.Manager;
import ir.maktabsharif92.fruitshop.repository.ManagerRepository;

import java.sql.Connection;

public class ManagerRepositoryImpl
        extends BaseUserGenericRepositoryImpl<Manager>
        implements ManagerRepository {

    public ManagerRepositoryImpl(Connection connection) {
        super(connection);
    }

}
