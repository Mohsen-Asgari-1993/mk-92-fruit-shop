package ir.maktabsharif92.fruitshop.base.repository;

import ir.maktabsharif92.fruitshop.base.domain.Entity;

import java.sql.*;

public abstract class BaseJDBCRepository implements BaseRepository {

    public static final String GET_BY_ID_QUERY_TEMPLATE =
            "SELECT * FROM %s WHERE id = ?";

    public static final String GET_ALL_QUERY_TEMPLATE =
            "SELECT * FROM %s";

    public static final String DELETE_BY_ID_QUERY_TEMPLATE =
            "DELETE FROM %s WHERE id = ?";

    public static final String INSERT_QUERY_TEMPLATE =
            "INSERT INTO %s(%s) VALUES(%s)";

    protected final Connection connection;

    public BaseJDBCRepository(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void save(Entity entity) throws SQLException {
//        saveFirstApproach(entity);
        saveSecondApproach(entity);
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
        Statement statement = connection.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY
        );

        ResultSet resultSet = statement.executeQuery(
                generateGetAllQuery()
        );

        resultSet.last();
        int size = resultSet.getRow();
        resultSet.beforeFirst();
        if (size > 0) {
            Entity[] entities = new Entity[size];
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

    @Override
    public void deleteById(Long id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                generateDeleteByIdQuery()
        );
        preparedStatement.setLong(1, id);
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

    private String generateInsertQueryFirstApproach(Entity entity) {
        return String.format(
                INSERT_QUERY_TEMPLATE,
                getEntityTableName(),
                getInsertColumnNames(),
                getInsertColumnValues(entity)
        );
    }

    protected void saveSecondApproach(Entity entity) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                generateInsertQuerySecondApproach()
        );
        fillPrepStatementForSave(preparedStatement, entity);
        preparedStatement.executeUpdate();
    }

    protected abstract void fillPrepStatementForSave(PreparedStatement preparedStatement, Entity entity) throws SQLException;

    protected String generateInsertQuerySecondApproach() {
        String[] columnNames = getInsertColumnNamesArray();

        return String.format(
                INSERT_QUERY_TEMPLATE,
                getEntityTableName(),
                String.join(",", columnNames),
                generateQuestionMarkForInsertQuery(columnNames.length)
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

    protected abstract String[] getInsertColumnNamesArray();

    private void saveFirstApproach(Entity entity) throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate(
                generateInsertQueryFirstApproach(entity)
        );
    }

    protected abstract String getEntityTableName();

    protected abstract Entity mapFullResultSetToEntity(ResultSet resultSet) throws SQLException;

    protected abstract String getInsertColumnNames();

    protected abstract String getInsertColumnValues(Entity entity);

}
