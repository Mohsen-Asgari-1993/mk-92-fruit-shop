package ir.maktabsharif92.fruitshop.repository.impl;

import ir.maktabsharif92.fruitshop.base.domain.BaseUser;
import ir.maktabsharif92.fruitshop.base.repository.BaseUserGenericRepositoryImpl;
import ir.maktabsharif92.fruitshop.repository.UserRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserRepositoryImpl
        extends BaseUserGenericRepositoryImpl<BaseUser>
        implements UserRepository {

    public UserRepositoryImpl(Connection connection) {
        super(connection);
    }

    @Override
    public void fillGetByIdPrepareStatement(PreparedStatement preparedStatement,
                                            Long id) throws SQLException {
//        SELECT * FROM %s WHERE id = ?
        fillIdInPrepareStatement(preparedStatement, id, 1);
    }

    @Override
    public void fillDeleteByIdPrepareStatement(PreparedStatement preparedStatement, Long id) throws SQLException {
        fillIdInPrepareStatement(preparedStatement, id, 1);
    }

    @Override
    public String generateDeleteByIdQuery() {
        return String.format(
                DELETE_BY_ID_QUERY_TEMPLATE,
                getEntityTableName()
        );
    }

    @Override
    public String generateGetByIdQuery() {
        return String.format(
                GET_BY_ID_QUERY_TEMPLATE,
                getEntityTableName()
        );
    }

    @Override
    public String generateGetAllQuery() {
        return String.format(
                GET_ALL_QUERY_TEMPLATE,
                getEntityTableName()
        );
    }

    @Override
    protected BaseUser getNewInstance() {
        return new BaseUser();
    }
}
