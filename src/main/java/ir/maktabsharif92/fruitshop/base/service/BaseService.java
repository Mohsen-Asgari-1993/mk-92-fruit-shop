package ir.maktabsharif92.fruitshop.base.service;

import ir.maktabsharif92.fruitshop.base.domain.Entity;

import java.sql.SQLException;

public interface BaseService {

    void save(Entity entity);

    Entity getById(Long id) throws SQLException;

    Entity[] getAll() throws SQLException;

    void deleteById(Long id) throws SQLException;

}
