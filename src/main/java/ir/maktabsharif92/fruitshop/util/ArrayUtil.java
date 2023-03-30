package ir.maktabsharif92.fruitshop.util;

import ir.maktabsharif92.fruitshop.base.domain.Entity;
import ir.maktabsharif92.fruitshop.domain.Address;
import ir.maktabsharif92.fruitshop.repository.Database;

public abstract class ArrayUtil {

    public static void addEntityToArray(Entity[] entities, Entity entity) {
        for (int i = 0; i < entities.length; i++) {
            if (entities[i] == null) {
                entities[i] = entity;
                break;
            }
        }
    }

    public static Entity[] increaseArrayLengthIfNecessaryAndGetNewArray(Entity[] entities) {
        if (entities != null && entities.length > 0) {

            Entity[] newEntities = entities;

            Entity en = entities[entities.length - 1];

            if (en != null) {

                newEntities = createNewArray(entities);

                for (int i = 0; i < entities.length; i++) {
                    newEntities[i] = entities[i];
                }

            }

            return newEntities;

        } else {
            return new Entity[Database.DEFAULT_ARRAY_LENGTH];
        }
    }

    private static Entity[] createNewArray(Entity[] entities) {
        if (entities instanceof Address[]) {
            return new Address[(entities.length * 2)];
        }
//        TODO complete for other types
        return null;
    }

}
