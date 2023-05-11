package ir.maktabsharif92.fruitshop.base.repository;

import ir.maktabsharif92.fruitshop.base.domain.BaseEntity;

import java.sql.SQLException;
import java.util.List;

public interface BaseGenericRepository<T extends BaseEntity<S>, S> {

    void save(T t) throws SQLException;

    T getById(S id) throws SQLException;

    List<T> getAll() throws SQLException;

    void deleteById(S id) throws SQLException;
}