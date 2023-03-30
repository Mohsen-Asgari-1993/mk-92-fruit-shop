package ir.maktabsharif92.fruitshop.repository.impl;

import ir.maktabsharif92.fruitshop.base.repository.BaseUserRepositoryImpl;
import ir.maktabsharif92.fruitshop.domain.Admin;
import ir.maktabsharif92.fruitshop.repository.AdminRepository;

public class AdminRepositoryImpl extends BaseUserRepositoryImpl
        implements AdminRepository {

    public AdminRepositoryImpl(Admin[] entities) {
        super(entities);
    }

}
