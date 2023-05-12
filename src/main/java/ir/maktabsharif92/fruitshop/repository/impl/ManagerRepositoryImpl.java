package ir.maktabsharif92.fruitshop.repository.impl;

import ir.maktabsharif92.fruitshop.base.repository.BaseUserGenericRepositoryImpl;
import ir.maktabsharif92.fruitshop.domain.Manager;
import ir.maktabsharif92.fruitshop.domain.enumeration.UserType;
import ir.maktabsharif92.fruitshop.repository.ManagerRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ManagerRepositoryImpl
        extends BaseUserGenericRepositoryImpl<Manager>
        implements ManagerRepository {

    public ManagerRepositoryImpl(Connection connection) {
        super(connection);
    }

    @Override
    public void fillGetByIdPrepareStatement(PreparedStatement preparedStatement, Long id) throws SQLException {
//        SELECT * FROM %s WHERE id = ? and user_type = ?
        fillIdInPrepareStatement(preparedStatement, id, 1);
//        UserType.CLIENT.name() == "MANAGER"
        preparedStatement.setString(2, UserType.MANAGER.name());
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
    protected Manager getNewInstance() {
        return new Manager();
    }

    @Override
    protected List<String> getInsertColumnNamesArray() {
        List<String> insertColumnNamesArray = super.getInsertColumnNamesArray();
        insertColumnNamesArray.add(Manager.IS_SUPER_MANAGER);
        return insertColumnNamesArray;
    }

    @Override
    protected void fillPrepStatementForSave(PreparedStatement preparedStatement, Manager manager)
            throws SQLException {
        super.fillPrepStatementForSave(preparedStatement, manager);
        preparedStatement.setString(
                9, manager.getIsSuperManager() ? "true" : "false"
        );
    }

    @Override
    protected Manager mapFullResultSetToEntity(ResultSet resultSet) throws SQLException {
        Manager manager = super.mapFullResultSetToEntity(resultSet);
        manager.setIsSuperManager(
                resultSet.getString(10).equals("true")
        );
        return manager;
    }
}
