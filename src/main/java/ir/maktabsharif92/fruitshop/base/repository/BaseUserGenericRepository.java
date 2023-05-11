package ir.maktabsharif92.fruitshop.base.repository;

import ir.maktabsharif92.fruitshop.base.domain.BaseUser;

import java.util.List;

public interface BaseUserGenericRepository<T extends BaseUser>
        extends BaseGenericRepository<T, Long> {

    T getByUsername(String username);

    T getByUsernameAndPassword(String username, String password);

    List<T> findAllByFirstName(String firstName);


}
