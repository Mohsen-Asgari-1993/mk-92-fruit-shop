package ir.maktabsharif92.fruitshop.service.impl;

import ir.maktabsharif92.fruitshop.base.domain.BaseUser;
import ir.maktabsharif92.fruitshop.base.service.BaseUserGenericServiceImpl;
import ir.maktabsharif92.fruitshop.repository.UserRepository;
import ir.maktabsharif92.fruitshop.service.UserService;

public class UserServiceImpl
        extends BaseUserGenericServiceImpl<BaseUser, UserRepository>
        implements UserService {

    public UserServiceImpl(UserRepository repository) {
        super(repository);
    }

    @Override
    public BaseUser getByUsername(String username) {
        return super.getByUsername(username);
    }
}
