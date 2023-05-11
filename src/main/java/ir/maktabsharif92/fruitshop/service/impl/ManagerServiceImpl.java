package ir.maktabsharif92.fruitshop.service.impl;

import ir.maktabsharif92.fruitshop.base.service.BaseUserGenericServiceImpl;
import ir.maktabsharif92.fruitshop.domain.Manager;
import ir.maktabsharif92.fruitshop.repository.ManagerRepository;
import ir.maktabsharif92.fruitshop.service.ManagerService;

public class ManagerServiceImpl
        extends BaseUserGenericServiceImpl
//        <T extends BaseUser, R extends BaseUserGenericRepository<T>>
//        <Manager, R extends BaseUserGenericRepository<Manager>>
        <Manager, ManagerRepository>
        implements ManagerService {

    public ManagerServiceImpl(ManagerRepository repository) {
        super(repository);
    }
}
