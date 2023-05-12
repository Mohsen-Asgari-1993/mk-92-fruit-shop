package ir.maktabsharif92.fruitshop.repository.impl;

import ir.maktabsharif92.fruitshop.base.repository.BaseGenericRepositoryImpl;
import ir.maktabsharif92.fruitshop.domain.WalletTransaction;
import ir.maktabsharif92.fruitshop.repository.WalletTransactionRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.List;

public class WalletTransactionRepositoryImpl
        extends BaseGenericRepositoryImpl<WalletTransaction, Long>
        implements WalletTransactionRepository {

    public WalletTransactionRepositoryImpl(Connection connection) {
        super(connection);
    }

    @Override
    protected String getEntityTableName() {
        return WalletTransaction.TABLE_NAME;
    }

    @Override
    protected WalletTransaction mapFullResultSetToEntity(ResultSet resultSet) throws SQLException {
        WalletTransaction wallet = new WalletTransaction();
        wallet.setId(
                resultSet.getLong(1)
        );
        wallet.setCustomerId(
                resultSet.getLong(2)
        );
        wallet.setWalletId(
                resultSet.getLong(3)
        );
        wallet.setTransactionType(
                resultSet.getString(4)
        );
        wallet.setTotalChange(
                resultSet.getLong(5)
        );
        wallet.setCashChange(
                resultSet.getLong(6)
        );
        wallet.setCreditChange(
                resultSet.getLong(7)
        );
        wallet.setTotalAmount(
                resultSet.getLong(8)
        );
        wallet.setCashAmount(
                resultSet.getLong(9)
        );
        wallet.setCreditAmount(
                resultSet.getLong(10)
        );

/*        Long createDate = ZonedDateTime.now()
                        .toInstant().toEpochMilli();*/

        wallet.setCreateDate(
                ZonedDateTime.ofInstant(
                        Instant.ofEpochMilli(
                                resultSet.getLong(11)
                        ),
                        ZoneId.systemDefault()
                )
        );
        wallet.setCode(
                resultSet.getString(12)
        );
        wallet.setTransactionPurpose(
                resultSet.getString(13)
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
    protected List<String> getInsertColumnNamesArray() {
        return Arrays.asList(
                WalletTransaction.CUSTOMER_ID,
                WalletTransaction.WALLET_ID,
                WalletTransaction.TOTAL_AMOUNT,
                WalletTransaction.CASH_AMOUNT,
                WalletTransaction.CREDIT_AMOUNT,
                WalletTransaction.TRANSACTION_TYPE,
                WalletTransaction.TOTAL_CHANGE,
                WalletTransaction.CASH_CHANGE,
                WalletTransaction.CREDIT_CHANGE,
                WalletTransaction.CREATE_DATE,
                WalletTransaction.CODE,
                WalletTransaction.TRANSACTION_PURPOSE
        );
    }

    @Override
    protected void fillPrepStatementForSave(PreparedStatement preparedStatement, WalletTransaction walletTransaction) throws SQLException {
        preparedStatement.setLong(1, walletTransaction.getCustomerId());
        preparedStatement.setLong(1, walletTransaction.getWalletId());
        preparedStatement.setString(1, walletTransaction.getTransactionType());
        preparedStatement.setLong(1, walletTransaction.getTotalChange());
        preparedStatement.setLong(1, walletTransaction.getCashChange());
        preparedStatement.setLong(1, walletTransaction.getCreditChange());
        preparedStatement.setLong(1, walletTransaction.getTotalAmount());
        preparedStatement.setLong(1, walletTransaction.getCashAmount());
        preparedStatement.setLong(1, walletTransaction.getCreditAmount());
        preparedStatement.setLong(
                1,
//                convert zonedDateTime to long (milli)
                walletTransaction.getCreateDate().toInstant().toEpochMilli()
        );
        preparedStatement.setString(1, walletTransaction.getCode());
        preparedStatement.setString(1, walletTransaction.getTransactionPurpose());
    }
}
