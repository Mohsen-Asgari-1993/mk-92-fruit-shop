package ir.maktabsharif92.fruitshop.base.service;

import ir.maktabsharif92.fruitshop.base.domain.Entity;
import ir.maktabsharif92.fruitshop.base.repository.BaseRepository;

import java.sql.SQLException;

public abstract class BaseServiceImpl implements BaseService {

    protected final BaseRepository repository;

    protected BaseServiceImpl(BaseRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(Entity entity) throws SQLException {
        repository.save(entity);
    }

    @Override
    public Entity getById(Long id) throws SQLException {
        return repository.getById(id);
    }

    @Override
    public Entity[] getAll() throws SQLException {
        return repository.getAll();
    }

    @Override
    public void deleteById(Long id) throws SQLException {
        repository.deleteById(id);
    }
}
