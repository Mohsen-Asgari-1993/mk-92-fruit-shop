package ir.maktabsharif92.fruitshop.base.service;

import ir.maktabsharif92.fruitshop.base.domain.BaseEntity;
import ir.maktabsharif92.fruitshop.base.repository.BaseGenericRepository;

import java.sql.SQLException;
import java.util.List;

public abstract class BaseGenericServiceImpl
        <T extends BaseEntity<S>, S, R extends BaseGenericRepository<T, S>>
        implements BaseGenericService<T, S> {

    protected final R repository;
//    protected final BaseGenericRepository<T, S> repository;

    public BaseGenericServiceImpl(R repository) {
//    public BaseGenericServiceImpl(BaseGenericRepository<T, S> repository) {
        this.repository = repository;
    }

    @Override
    public void save(T t) throws SQLException {
        repository.save(t);
    }

    @Override
    public T getById(S id) throws SQLException {
        return repository.getById(id);
    }

    @Override
    public List<T> getAll() throws SQLException {
        return repository.getAll();
    }

    @Override
    public void deleteById(S id) throws SQLException {
        repository.deleteById(id);
    }
}
