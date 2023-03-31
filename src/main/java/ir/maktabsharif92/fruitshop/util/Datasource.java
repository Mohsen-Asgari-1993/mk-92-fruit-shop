package ir.maktabsharif92.fruitshop.util;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class Datasource {

    private static final HikariConfig hikariConfig = new HikariConfig();
    private static final HikariDataSource dataSource;

    static {
        hikariConfig.setJdbcUrl(
                ApplicationProperties.DATABASE_URL
        );
        hikariConfig.setUsername(
                ApplicationProperties.DATABASE_USER
        );
        hikariConfig.setPassword(
                ApplicationProperties.DATABASE_PASSWORD
        );
        hikariConfig.setMaximumPoolSize(10);
//        hikariConfig.addDataSourceProperty();
        dataSource = new HikariDataSource(hikariConfig);
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }


}
