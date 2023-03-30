package ir.maktabsharif92.fruitshop.base.repository;

import ir.maktabsharif92.fruitshop.base.domain.User;

public interface BaseUserRepository extends BaseRepository {

    User getByUsername(String username);

}
