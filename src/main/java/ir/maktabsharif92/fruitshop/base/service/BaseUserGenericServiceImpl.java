package ir.maktabsharif92.fruitshop.base.service;

import ir.maktabsharif92.fruitshop.base.domain.BaseUser;
import ir.maktabsharif92.fruitshop.base.repository.BaseUserGenericRepository;

import java.util.List;

public class BaseUserGenericServiceImpl
        <T extends BaseUser, R extends BaseUserGenericRepository<T>>
        extends BaseGenericServiceImpl<T, Long, R>
        implements BaseUserGenericService<T> {

    public BaseUserGenericServiceImpl(R repository) {
        super(repository);
    }

    @Override
    public T getByUsername(String username) {
        return repository.getByUsername(username);
    }

    @Override
    public T getByUsernameAndPassword(String username, String password) {
        return repository.getByUsernameAndPassword(username, password);
    }

    @Override
    public List<T> findAllByFirstName(String firstName) {
        return repository.findAllByFirstName(firstName);
    }
}
