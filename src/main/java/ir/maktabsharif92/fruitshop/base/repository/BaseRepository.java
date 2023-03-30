package ir.maktabsharif92.fruitshop.base.repository;

import ir.maktabsharif92.fruitshop.base.domain.Entity;

public interface BaseRepository {

    void insert(Entity entity);

    Entity getById(Long id);

    Entity[] getAll();

    void deleteById(Long id);

}
