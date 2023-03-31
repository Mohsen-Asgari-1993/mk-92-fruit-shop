package ir.maktabsharif92.fruitshop.base.repository;

import ir.maktabsharif92.fruitshop.base.domain.User;
import ir.maktabsharif92.fruitshop.repository.Database;

public class BaseUserRepositoryImpl extends BaseRepositoryImpl
        implements BaseUserRepository {

    public BaseUserRepositoryImpl(User[] entities) {
        super(entities);
    }

    @Override
    public User getByUsername(String username) {
        User[] users = (User[]) entities;
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    @Override
    protected void copyTable() {
        Database.setUsers((User[]) entities);
    }
}
