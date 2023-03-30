package ir.maktabsharif92.fruitshop.repository.impl;

import ir.maktabsharif92.fruitshop.base.domain.Entity;
import ir.maktabsharif92.fruitshop.base.repository.BaseRepositoryImpl;
import ir.maktabsharif92.fruitshop.repository.FruitRepository;

public class FruitRepositoryImpl extends BaseRepositoryImpl
        implements FruitRepository {

    public FruitRepositoryImpl(Entity[] entities) {
        super(entities);
    }

}
