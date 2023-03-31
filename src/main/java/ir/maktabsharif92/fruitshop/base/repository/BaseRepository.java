package ir.maktabsharif92.fruitshop.base.repository;

import ir.maktabsharif92.fruitshop.base.domain.Entity;

import java.sql.SQLException;

public interface BaseRepository {

    void save(Entity entity) throws SQLException;

    Entity getById(Long id) throws SQLException;

    Entity[] getAll() throws SQLException;

    void deleteById(Long id) throws SQLException;

}
