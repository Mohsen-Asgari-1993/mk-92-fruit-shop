package ir.maktabsharif92.fruitshop.base.repository;

import ir.maktabsharif92.fruitshop.base.domain.Entity;

import java.util.Objects;

public class BaseRepositoryImpl implements BaseRepository {

    protected Entity[] entities;

    private long sequence = 1;

    public BaseRepositoryImpl(Entity[] entities) {
        this.entities = entities;
    }

    @Override
    public void insert(Entity entity) {
        int length = entities.length;
        Entity en = entities[length - 1];
        if (en != null) {
            increaseArrayLength();
        }
        addEntityToArray(entity);
    }


    @Override
    public Entity getById(Long id) {
        if (isArrayValid()) {
            for (Entity entity : entities) {
                if (Objects.equals(entity.getId(), id)) {
                    return entity;
                }
            }
        }
        return null;
    }

    @Override
    public Entity[] getAll() {
        return entities;
    }

    @Override
    public void deleteById(Long id) {

        if (isArrayValid()) {
            boolean isEntityFound = false;
            int foundedEntityIndex = 0;

            for (int i = 0; i < entities.length; i++) {
                if (entities[i] != null && entities[i].getId().equals(id)) {
                    foundedEntityIndex = i;
                    isEntityFound = true;
                    entities[i] = null;
                    break;
                }
            }
            if (isEntityFound) {
                shiftBack(foundedEntityIndex);
            }
        }

    }

    protected void shiftBack(int fromIndex) {
        for (int i = fromIndex; i < entities.length; i++) {
            if (i == entities.length - 1) {
                entities[i] = null;
            } else {
                if (entities[i + 1] != null) {
                    entities[i] = entities[i + 1];
                } else {
                    break;
                }
            }
        }
    }

    protected void increaseArrayLength() {
        Entity[] newEntities = new Entity[(entities.length * 2)];

        for (int i = 0; i < entities.length; i++) {
            newEntities[i] = this.entities[i];
        }

        this.entities = newEntities;
    }

    protected void addEntityToArray(Entity entity) {
        for (int i = 0; i < entities.length; i++) {
            if (entities[i] == null) {
                entity.setId(sequence++);
                entities[i] = entity;
                break;
            }
        }
    }

    protected boolean isArrayValid() {
        return entities != null && entities.length > 0;
    }

}
