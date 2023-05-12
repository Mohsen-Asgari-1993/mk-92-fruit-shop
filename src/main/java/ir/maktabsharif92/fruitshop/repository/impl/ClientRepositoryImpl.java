package ir.maktabsharif92.fruitshop.repository.impl;

import ir.maktabsharif92.fruitshop.base.repository.BaseUserGenericRepositoryImpl;
import ir.maktabsharif92.fruitshop.domain.Client;
import ir.maktabsharif92.fruitshop.domain.enumeration.UserType;
import ir.maktabsharif92.fruitshop.repository.ClientRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ClientRepositoryImpl
        extends BaseUserGenericRepositoryImpl<Client>
        implements ClientRepository {

    public ClientRepositoryImpl(Connection connection) {
        super(connection);
    }

    @Override
    public void fillGetByIdPrepareStatement(PreparedStatement preparedStatement, Long id) throws SQLException {
//        SELECT * FROM %s WHERE id = ? and user_type = ?
        fillIdInPrepareStatement(preparedStatement, id, 1);
//        UserType.CLIENT.name() == "CLIENT"
        preparedStatement.setString(2, UserType.CLIENT.name());
    }

    @Override
    public String generateGetByIdQuery() {

        String query = GET_BY_ID_QUERY_TEMPLATE.concat(
                " and user_type = ?"
        );

        return String.format(
                query,
                getEntityTableName()
        );
    }

    @Override
    public void fillDeleteByIdPrepareStatement(PreparedStatement preparedStatement, Long id) throws SQLException {
        fillIdInPrepareStatement(preparedStatement, id, 1);

        preparedStatement.setString(2, UserType.CLIENT.name());
    }

    @Override
    public String generateDeleteByIdQuery() {
        //        String query = DELETE_BY_ID_QUERY_TEMPLATE.concat(
//                " and user_type = 'CLIENT'"
//        );
        String query = DELETE_BY_ID_QUERY_TEMPLATE.concat(
                " and user_type = ?"
        );

        return String.format(
                query,
                getEntityTableName()
        );
    }

    @Override
    public String generateGetAllQuery() {

        String query = GET_ALL_QUERY_TEMPLATE
                .concat(" where user_type = '" + UserType.CLIENT.name() + "'");

        return String.format(
                query, getEntityTableName()
        );
    }

    @Override
    protected void fillGetByUsernamePrepStatement(PreparedStatement preparedStatement, String username) throws SQLException {
        super.fillGetByUsernamePrepStatement(preparedStatement, username);
        preparedStatement.setString(2, UserType.CLIENT.name());
    }

    @Override
    protected String generateGetByUsernameQuery() {
        return GET_BY_USERNAME_QUERY_TEMPLATE.concat(
                " and user_type = ?"
        );
    }

    @Override
    protected Client getNewInstance() {
        return new Client();
    }

    @Override
    protected List<String> getInsertColumnNamesArray() {
        List<String> insertColumnNamesArray = super.getInsertColumnNamesArray();
//        TODO add client columns
        insertColumnNamesArray.add(Client.CODE);
        return insertColumnNamesArray;
    }

    @Override
    protected void fillPrepStatementForSave(PreparedStatement preparedStatement, Client client)
            throws SQLException {
        super.fillPrepStatementForSave(preparedStatement, client);
        preparedStatement.setString(9, client.getCode());
    }

    @Override
    protected Client mapFullResultSetToEntity(ResultSet resultSet) throws SQLException {
        Client client = super.mapFullResultSetToEntity(resultSet);
        client.setCode(
                resultSet.getString(11)
        );
        return client;
    }
}
