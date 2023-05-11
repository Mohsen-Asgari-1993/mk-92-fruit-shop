package ir.maktabsharif92.fruitshop.service.impl;

import ir.maktabsharif92.fruitshop.base.service.BaseUserGenericServiceImpl;
import ir.maktabsharif92.fruitshop.domain.Client;
import ir.maktabsharif92.fruitshop.repository.ClientRepository;
import ir.maktabsharif92.fruitshop.service.ClientService;

public class ClientServiceImpl
        extends BaseUserGenericServiceImpl
//        <T extends BaseUser, R extends BaseUserGenericRepository<T>>
//        <Client, R extends BaseUserGenericRepository<Client>>
        <Client, ClientRepository>
        implements ClientService {

    public ClientServiceImpl(ClientRepository repository) {
        super(repository);
    }
}
