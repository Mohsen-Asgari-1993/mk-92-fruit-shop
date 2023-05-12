package ir.maktabsharif92.fruitshop.base.repository;

import ir.maktabsharif92.fruitshop.base.domain.BaseEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseGenericRepositoryImpl<T extends BaseEntity<S>, S>
        implements BaseGenericRepository<T, S> {

    public static final String GET_BY_ID_QUERY_TEMPLATE =
            "SELECT * FROM %s WHERE id = ?";

    public static final String GET_ALL_QUERY_TEMPLATE =
            "SELECT * FROM %s";

    public static final String DELETE_BY_ID_QUERY_TEMPLATE =
            "DELETE FROM %s WHERE id = ?";

    public static final String INSERT_QUERY_TEMPLATE =
            "INSERT INTO %s(%s) VALUES(%s)";

    protected final Connection connection;

    protected BaseGenericRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void save(T t) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                generateInsertQuery()
        );
        fillPrepStatementForSave(preparedStatement, t);
        preparedStatement.executeUpdate();
    }

    @Override
    public T getById(S id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                generateGetByIdQuery()
        );
//        preparedStatement.setLong(1, id);
        fillIdInPrepareStatement(preparedStatement, id, 1);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return mapFullResultSetToEntity(resultSet);
        }
        return null;
    }

    @Override
    public List<T> getAll() throws SQLException {
        Statement statement = connection.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY
        );

        ResultSet resultSet = statement.executeQuery(
                generateGetAllQuery()
        );

        List<T> tList = new ArrayList<>();

        while (resultSet.next()) {
            tList.add(
                    mapFullResultSetToEntity(resultSet)
            );
        }
        return tList;
    }

    @Override
    public void deleteById(S id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                generateDeleteByIdQuery()
        );
//        preparedStatement.setLong(1, id);
        fillIdInPrepareStatement(preparedStatement, id, 1);
        preparedStatement.executeUpdate();
    }

    public String generateGetByIdQuery() {
        return String.format(
                GET_BY_ID_QUERY_TEMPLATE,
                getEntityTableName()
        );
    }

    public String generateGetAllQuery() {
        return String.format(
                GET_ALL_QUERY_TEMPLATE,
                getEntityTableName()
        );
    }

    public String generateDeleteByIdQuery() {
        return String.format(
                DELETE_BY_ID_QUERY_TEMPLATE,
                getEntityTableName()
        );
    }

    protected String generateInsertQuery() {
        List<String> columnNames = getInsertColumnNamesArray();

        return String.format(
                INSERT_QUERY_TEMPLATE,
                getEntityTableName(),
                String.join(",", columnNames),
                generateQuestionMarkForInsertQuery(columnNames.size())
        );
    }

    protected String generateQuestionMarkForInsertQuery(int length) {
        String result = "";
        for (int i = 0; i < length; i++) {
            if (i == length - 1) {
                result = result.concat("?");
            } else {
                result = result.concat("?,");
            }
        }
        return result;
    }

    protected abstract String getEntityTableName();

    protected abstract T mapFullResultSetToEntity(ResultSet resultSet) throws SQLException;

    protected abstract void fillIdInPrepareStatement(PreparedStatement preparedStatement,
                                                     S id,
                                                     int parameterIndex) throws SQLException;

    protected abstract List<String> getInsertColumnNamesArray();

    protected abstract void fillPrepStatementForSave(PreparedStatement preparedStatement,
                                                     T t) throws SQLException;


}
