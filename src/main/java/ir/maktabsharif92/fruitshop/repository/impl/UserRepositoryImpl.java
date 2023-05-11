package ir.maktabsharif92.fruitshop.repository.impl;

import ir.maktabsharif92.fruitshop.base.domain.BaseUser;
import ir.maktabsharif92.fruitshop.base.repository.BaseUserGenericRepositoryImpl;
import ir.maktabsharif92.fruitshop.repository.UserRepository;

import java.sql.Connection;

public class UserRepositoryImpl
        extends BaseUserGenericRepositoryImpl<BaseUser>
        implements UserRepository {

    public UserRepositoryImpl(Connection connection) {
        super(connection);
    }
}
