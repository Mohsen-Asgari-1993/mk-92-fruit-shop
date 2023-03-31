package ir.maktabsharif92.fruitshop.base.repository;

import ir.maktabsharif92.fruitshop.base.domain.Entity;

import java.sql.*;

public abstract class BaseJDBCRepository implements BaseRepository {

    public static final String GET_BY_ID_QUERY_TEMPLATE =
            "SELECT * FROM %s WHERE id = ?";
    public static final String GET_ALL_QUERY_TEMPLATE =
            "SELECT * FROM %s";
    protected final Connection connection;

    protected BaseJDBCRepository(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Entity getById(Long id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                generateGetByIdQuery()
        );
        preparedStatement.setLong(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return mapFullResultSetToEntity(resultSet);
        }
        return null;
    }

    @Override
    public Entity[] getAll() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(
                generateGetAllQuery()
        );

        int fetchSize = resultSet.getFetchSize();
        if (fetchSize > 0) {
            Entity[] entities = new Entity[fetchSize];
            int index = 0;
            while (resultSet.next()) {

                Entity entity = mapFullResultSetToEntity(
                        resultSet
                );
                entities[index++] = entity;
                /*ArrayUtil.addEntityToArray(
                        entities,
                        entity
                );*/
            }
            return entities;
        } else {
            return null;
        }

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

    protected abstract String getEntityTableName();

    protected abstract Entity mapFullResultSetToEntity(ResultSet resultSet);

}
