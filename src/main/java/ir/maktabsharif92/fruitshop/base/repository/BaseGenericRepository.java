package ir.maktabsharif92.fruitshop.base.repository;

import ir.maktabsharif92.fruitshop.base.domain.BaseEntity;

import java.util.List;

public interface BaseGenericRepository<T extends BaseEntity<S>, S> {

    void save(T t);

    T getById(S id);

    List<T> getAll();

    void deleteById(S id);
}