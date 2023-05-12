package ir.maktabsharif92.fruitshop.service.impl;

import ir.maktabsharif92.fruitshop.base.service.BaseGenericServiceImpl;
import ir.maktabsharif92.fruitshop.domain.WalletTransaction;
import ir.maktabsharif92.fruitshop.repository.WalletTransactionRepository;
import ir.maktabsharif92.fruitshop.service.WalletTransactionService;

public class WalletTransactionServiceImpl
        extends BaseGenericServiceImpl<WalletTransaction, Long, WalletTransactionRepository>
        implements WalletTransactionService {

    public WalletTransactionServiceImpl(WalletTransactionRepository repository) {
        super(repository);
    }
}
