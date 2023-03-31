package ir.maktabsharif92.fruitshop.repository.impl;

import ir.maktabsharif92.fruitshop.base.domain.Entity;
import ir.maktabsharif92.fruitshop.base.repository.BaseJDBCRepository;
import ir.maktabsharif92.fruitshop.domain.Province;
import ir.maktabsharif92.fruitshop.repository.ProvinceRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProvinceRepositoryImpl extends BaseJDBCRepository
        implements ProvinceRepository {

    public ProvinceRepositoryImpl(Connection connection) {
        super(connection);
    }

    @Override
    protected String getEntityTableName() {
        return /*ApplicationProperties.DATABASE_NAME + "." +*/ Province.TABLE_NAME;
    }

    @Override
    protected Entity mapFullResultSetToEntity(ResultSet resultSet) throws SQLException {
        Province province = new Province();

        province.setId(
                resultSet.getLong(1)
        );

        province.setName(
                resultSet.getString(2)
        );

        return province;
    }

    @Override
    protected String getInsertColumnNames() {
        return Province.NAME;
    }

    @Override
    protected String getInsertColumnValues(Entity entity) {
        Province province = (Province) entity;
        return "'" + province.getName() + "'";
    }

    @Override
    public Province getByName(String name) throws SQLException {
        String query = "SELECT * FROM " + getEntityTableName() + " WHERE name = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, name);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return (Province) mapFullResultSetToEntity(resultSet);
        }
        return null;
    }
}
