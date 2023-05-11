package ir.maktabsharif92.fruitshop.base.repository;

import ir.maktabsharif92.fruitshop.base.domain.BaseUser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class BaseUserGenericRepositoryImpl<T extends BaseUser>
        extends BaseGenericRepositoryImpl<T, Long>
        implements BaseUserGenericRepository<T> {

    protected BaseUserGenericRepositoryImpl(Connection connection) {
        super(connection);
    }

    @Override
    protected String getEntityTableName() {
        return null;
    }

    @Override
    protected T mapFullResultSetToEntity(ResultSet resultSet) throws SQLException {
        return null;
    }

    @Override
    protected void fillIdInPrepareStatement(PreparedStatement preparedStatement, Long id, int parameterIndex) throws SQLException {

    }

    @Override
    protected String[] getInsertColumnNamesArray() {
        return new String[0];
    }

    @Override
    protected void fillPrepStatementForSave(PreparedStatement preparedStatement, T t) throws SQLException {

    }

    @Override
    public T getByUsername(String username) {
        return null;
    }

    @Override
    public T getByUsernameAndPassword(String username, String password) {
        return null;
    }

    @Override
    public List<T> findAllByFirstName(String firstName) {
        return null;
    }
}
