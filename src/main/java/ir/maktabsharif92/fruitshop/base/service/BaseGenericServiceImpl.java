package ir.maktabsharif92.fruitshop.base.service;

import ir.maktabsharif92.fruitshop.base.domain.BaseEntity;
import ir.maktabsharif92.fruitshop.base.repository.BaseGenericRepository;

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
    public void save(T t) {
        repository.save(t);
    }

    @Override
    public T getById(S id) {
        return repository.getById(id);
    }

    @Override
    public List<T> getAll() {
        return repository.getAll();
    }

    @Override
    public void deleteById(S id) {
        repository.deleteById(id);
    }
}
