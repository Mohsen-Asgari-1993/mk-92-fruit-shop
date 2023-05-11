package ir.maktabsharif92.fruitshop.repository.impl;

import ir.maktabsharif92.fruitshop.base.repository.BaseGenericRepositoryImpl;
import ir.maktabsharif92.fruitshop.domain.Wallet;
import ir.maktabsharif92.fruitshop.repository.WalletRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class WalletRepositoryImpl
        extends BaseGenericRepositoryImpl<Wallet, Long>
        implements WalletRepository {

    public WalletRepositoryImpl(Connection connection) {
        super(connection);
    }

    @Override
    protected String getEntityTableName() {
        return Wallet.TABLE_NAME;
    }

    @Override
    protected Wallet mapFullResultSetToEntity(ResultSet resultSet) throws SQLException {
        Wallet wallet = new Wallet();
        wallet.setId(
                resultSet.getLong(1)
        );
        wallet.setCustomerId(
                resultSet.getLong(2)
        );
        wallet.setTotalAmount(
                resultSet.getLong(3)
        );
        wallet.setCashAmount(
                resultSet.getLong(4)
        );
        wallet.setCreditAmount(
                resultSet.getLong(5)
        );

        return wallet;
    }

    @Override
    protected void fillIdInPrepareStatement(PreparedStatement preparedStatement,
                                            Long id,
                                            int parameterIndex) throws SQLException {
        preparedStatement.setLong(parameterIndex, id);
    }

    @Override
    protected String[] getInsertColumnNamesArray() {
        return new String[]{
                Wallet.CUSTOMER_ID,
                Wallet.TOTAL_AMOUNT,
                Wallet.CASH_AMOUNT,
                Wallet.CREDIT_AMOUNT
        };
    }

    @Override
    protected void fillPrepStatementForSave(PreparedStatement preparedStatement, Wallet wallet) throws SQLException {
        preparedStatement.setLong(1, wallet.getCustomerId());
        preparedStatement.setLong(2, wallet.getTotalAmount());
        preparedStatement.setLong(3, wallet.getCashAmount());
        preparedStatement.setLong(4, wallet.getCreditAmount());
    }
}
