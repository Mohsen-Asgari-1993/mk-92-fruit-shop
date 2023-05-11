package ir.maktabsharif92.fruitshop.service.impl;

import ir.maktabsharif92.fruitshop.base.service.BaseGenericServiceImpl;
import ir.maktabsharif92.fruitshop.domain.Wallet;
import ir.maktabsharif92.fruitshop.repository.WalletRepository;
import ir.maktabsharif92.fruitshop.service.WalletService;

public class WalletServiceImpl
        extends BaseGenericServiceImpl<Wallet, Long, WalletRepository>
        implements WalletService {

    public WalletServiceImpl(WalletRepository repository) {
        super(repository);
    }
}
