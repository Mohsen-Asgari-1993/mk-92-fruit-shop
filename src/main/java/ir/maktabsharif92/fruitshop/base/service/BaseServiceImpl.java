package ir.maktabsharif92.fruitshop.base.service;

import ir.maktabsharif92.fruitshop.base.domain.Entity;
import ir.maktabsharif92.fruitshop.base.repository.BaseRepository;

public abstract class BaseServiceImpl implements BaseService {

    protected final BaseRepository repository;

    protected BaseServiceImpl(BaseRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(Entity entity) {
        repository.save(entity);
    }

    @Override
    public Entity getById(Long id) {
        return repository.getById(id);
    }

    @Override
    public Entity[] getAll() {
        return repository.getAll();
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
