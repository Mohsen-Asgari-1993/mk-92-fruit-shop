package ir.maktabsharif92.fruitshop.base.repository;

import ir.maktabsharif92.fruitshop.base.domain.BaseUser;

import java.util.List;

public interface BaseUserGenericRepository
        extends BaseGenericRepository<BaseUser, Long> {

    BaseUser getByUsername(String username);

    BaseUser getByUsernameAndPassword(String username, String password);

    List<BaseUser> findAllByFirstName(String firstName);

}
