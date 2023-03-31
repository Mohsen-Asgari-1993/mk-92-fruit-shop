package ir.maktabsharif92.fruitshop.repository.impl;

import ir.maktabsharif92.fruitshop.base.domain.Entity;
import ir.maktabsharif92.fruitshop.base.repository.BaseJDBCRepository;
import ir.maktabsharif92.fruitshop.domain.City;
import ir.maktabsharif92.fruitshop.repository.CityRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CityRepositoryImpl extends BaseJDBCRepository implements CityRepository {

    public CityRepositoryImpl(Connection connection) {
        super(connection);
    }

    @Override
    protected String getEntityTableName() {
        return City.TABLE_NAME;
    }

    @Override
    protected Entity mapFullResultSetToEntity(ResultSet resultSet) throws SQLException {
        City city = new City();

        city.setId(resultSet.getLong(1));
        city.setName(resultSet.getString(2));
        city.setProvinceId(resultSet.getLong(3));

        return city;

        /*return new City(
                resultSet.getLong(1),
                resultSet.getString(2),
                resultSet.getLong(3)
        );*/
    }

    @Override
    protected String getInsertColumnNames() {
        return City.NAME + ", " + City.PROVINCE_ID;
    }

    @Override
    protected String getInsertColumnValues(Entity entity) {
        City city = (City) entity;
        return "'" + city.getName() + "', " + city.getProvinceId();
    }


    @Override
    protected void fillPrepStatementForSave(PreparedStatement preparedStatement, Entity entity) throws SQLException {
        City city = (City) entity;
        preparedStatement.setString(
                1, city.getName()
        );
        preparedStatement.setLong(
                2, city.getProvinceId()
        );
    }

    @Override
    protected String[] getInsertColumnNamesArray() {
        return new String[]{
                City.NAME,
                City.PROVINCE_ID
        };
    }
}
