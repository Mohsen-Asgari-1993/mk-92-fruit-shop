package ir.maktabsharif92.fruitshop.base.repository;

import ir.maktabsharif92.fruitshop.base.domain.BaseEntity;

import java.util.List;

public class BaseGenericRepositoryImpl<T extends BaseEntity<S>, S>
        implements BaseGenericRepository<T, S> {

    @Override
    public void save(T t) {

    }

    @Override
    public T getById(S id) {
        return null;
    }

    @Override
    public List<T> getAll() {
        return null;
    }

    @Override
    public void deleteById(S id) {

    }
}
