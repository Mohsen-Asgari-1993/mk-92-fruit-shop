package ir.maktabsharif92.fruitshop.base.service;

import ir.maktabsharif92.fruitshop.base.domain.Entity;

public interface BaseService {

    void save(Entity entity);

    Entity getById(Long id);

    Entity[] getAll();

    void deleteById(Long id);

}
