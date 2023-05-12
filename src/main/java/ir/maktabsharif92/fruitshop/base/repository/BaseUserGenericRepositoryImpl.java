package ir.maktabsharif92.fruitshop.base.repository;

import ir.maktabsharif92.fruitshop.base.domain.BaseUser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseUserGenericRepositoryImpl<T extends BaseUser>
        extends BaseGenericRepositoryImpl<T, Long>
        implements BaseUserGenericRepository<T> {

    //    public static final String GET_BY_USERNAME_LIKE_QUERY_TEMPLATE =
//            "select * form " + BaseUser.TABLE_NAME + " where " + BaseUser.USERNAME + " like ?";
    public static final String GET_BY_USERNAME_QUERY_TEMPLATE =
            "select * from " + BaseUser.TABLE_NAME + " where " + BaseUser.USERNAME + " = ?";

    public BaseUserGenericRepositoryImpl(Connection connection) {
        super(connection);
    }

    @Override
    public T getById(Long id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                generateGetByIdQuery()
        );

//        SELECT * FROM %s WHERE id = ?
//        SELECT * FROM %s WHERE id = ? and user_type = ?

        fillGetByIdPrepareStatement(preparedStatement, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return mapFullResultSetToEntity(resultSet);
        }
        return null;
    }

    @Override
    public void deleteById(Long id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                generateDeleteByIdQuery()
        );
        fillDeleteByIdPrepareStatement(preparedStatement, id);
        preparedStatement.executeUpdate();
    }

    public abstract void fillGetByIdPrepareStatement(PreparedStatement preparedStatement, Long id) throws SQLException;

    public abstract void fillDeleteByIdPrepareStatement(PreparedStatement preparedStatement, Long id) throws SQLException;

    @Override
    public abstract String generateDeleteByIdQuery();

    @Override
    public abstract String generateGetByIdQuery();

    @Override
    public abstract String generateGetAllQuery();

    @Override
    protected String getEntityTableName() {
        return BaseUser.TABLE_NAME;
    }

    @Override
    protected T mapFullResultSetToEntity(ResultSet resultSet) throws SQLException {
        T t = getNewInstance();
        t.setId(resultSet.getLong(1));
        t.setFirstName(resultSet.getString(2));
        t.setLastName(resultSet.getString(3));
        t.setUsername(resultSet.getString(4));
        t.setPassword(resultSet.getString(5));
        t.setAge(resultSet.getInt(6));
        t.setUserType(resultSet.getString(7));
        t.setNationalCode(resultSet.getString(8));
        t.setIsActive(
                resultSet.getString(9).equals("true")
        );
        return t;
    }

    protected abstract T getNewInstance();

    @Override
    protected void fillIdInPrepareStatement(PreparedStatement preparedStatement,
                                            Long id,
                                            int parameterIndex) throws SQLException {
        preparedStatement.setLong(parameterIndex, id);
    }

    @Override
    protected List<String> getInsertColumnNamesArray() {
        List<String> insertColumns = new ArrayList<>();
        insertColumns.add(BaseUser.FIRST_NAME);
        insertColumns.add(BaseUser.LAST_NAME);
        insertColumns.add(BaseUser.USERNAME);
        insertColumns.add(BaseUser.PASSWORD);
        insertColumns.add(BaseUser.AGE);
        insertColumns.add(BaseUser.USER_TYPE);
        insertColumns.add(BaseUser.NATIONAL_CODE);
        insertColumns.add(BaseUser.IS_ACTIVE);
        return insertColumns;
    }

    @Override
    protected void fillPrepStatementForSave(PreparedStatement preparedStatement, T t) throws SQLException {
        preparedStatement.setString(1, t.getFirstName());
        preparedStatement.setString(2, t.getLastName());
        preparedStatement.setString(3, t.getUsername());
        preparedStatement.setString(4, t.getPassword());
        preparedStatement.setInt(5, t.getAge());
        preparedStatement.setString(6, t.getUserType());
        preparedStatement.setString(7, t.getNationalCode());
        preparedStatement.setString(8, t.getIsActive() ? "true" : "false");
    }

    @Override
    public T getByUsername(String username) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                generateGetByUsernameQuery()
        );
        fillGetByUsernamePrepStatement(preparedStatement, username);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return mapFullResultSetToEntity(resultSet);
        }
        return null;
    }

    //    protected abstract void fillGetByUsernamePrepStatement(PreparedStatement preparedStatement, String username);
    protected void fillGetByUsernamePrepStatement(PreparedStatement preparedStatement, String username)
            throws SQLException {
//        for like query
//        preparedStatement.setString(
//                1, "%" + username + "%"
//        );
        preparedStatement.setString(
                1, username
        );
    }

    protected String generateGetByUsernameQuery() {
        return GET_BY_USERNAME_QUERY_TEMPLATE;
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
