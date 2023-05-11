package ir.maktabsharif92.fruitshop.base.service;

import ir.maktabsharif92.fruitshop.base.domain.BaseEntity;

import java.util.List;

public interface BaseGenericService<T extends BaseEntity<S>, S> {

    void save(T t);

    T getById(S id);

    List<T> getAll();

    void deleteById(S id);
}
