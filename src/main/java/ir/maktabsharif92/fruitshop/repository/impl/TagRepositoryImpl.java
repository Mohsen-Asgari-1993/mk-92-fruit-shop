package ir.maktabsharif92.fruitshop.repository.impl;

import ir.maktabsharif92.fruitshop.base.domain.Entity;
import ir.maktabsharif92.fruitshop.base.repository.BaseRepositoryImpl;
import ir.maktabsharif92.fruitshop.repository.TagRepository;

public class TagRepositoryImpl extends BaseRepositoryImpl
        implements TagRepository {

    public TagRepositoryImpl(Entity[] entities) {
        super(entities);
    }

}
