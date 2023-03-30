package ir.maktabsharif92.fruitshop.repository.impl;

import ir.maktabsharif92.fruitshop.base.repository.BaseUserRepositoryImpl;
import ir.maktabsharif92.fruitshop.domain.Admin;
import ir.maktabsharif92.fruitshop.repository.CustomerRepository;

public class CustomerRepositoryImpl extends BaseUserRepositoryImpl
        implements CustomerRepository {

    public CustomerRepositoryImpl(Admin[] entities) {
        super(entities);
    }

}
