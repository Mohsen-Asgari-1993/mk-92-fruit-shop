package ir.maktabsharif92.fruitshop.base.service;

import ir.maktabsharif92.fruitshop.base.domain.BaseUser;

import java.util.List;

public interface BaseUserGenericService<T extends BaseUser>
        extends BaseGenericService<T, Long> {

    T getByUsername(String username);

    T getByUsernameAndPassword(String username, String password);

    List<T> findAllByFirstName(String firstName);

}